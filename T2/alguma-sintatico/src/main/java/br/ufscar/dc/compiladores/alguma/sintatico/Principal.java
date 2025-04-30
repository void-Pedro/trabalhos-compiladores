package br.ufscar.dc.compiladores.alguma.sintatico;

import org.antlr.v4.runtime.*;

import java.io.*;


public final class Principal {

    
    private Principal() { }

   
    public static void main(String[] args) {
        /*
         * Esperamos exatamente dois argumentos:
         *   args[0] – caminho do arquivo‑fonte a ser compilado;
         *   args[1] – caminho onde será criado/escrito o relatório.
         */
        if (args.length < 2) {
            System.err.println("Uso: java Principal <arquivo_entrada> <arquivo_saida>");
            System.exit(1);
        }

        String inputPath  = args[0];
        String outputPath = args[1];

        /* try‑with‑resources garante fechamento mesmo em caso de exceção */
        try (FileWriter writer = createWriter(outputPath)) {
            Output.init(writer);                // disponibiliza o writer globalmente

            // -------------------------- LEXER ---------------------------
            CharStream cs     = CharStreams.fromFileName(inputPath);
            AlgumaLexer lexer = new AlgumaLexer(cs);
            lexer.removeErrorListeners();
            lexer.addErrorListener(ErrorListener.INSTANCE);

            // -------------------------- PARSER --------------------------
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            AlgumaParser parser     = new AlgumaParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(ErrorListener.INSTANCE);

            /*
             * Regra inicial da gramática; se ocorrer erro, ErrorListener
             * dispara System.exit(0) e nada abaixo é executado.
             */
            parser.programa();

            /* Chegando aqui: compilação bem‑sucedida */
            Output.writeln("Fim da compilacao");
        } catch (IOException ioe) {
            System.err.println("Erro de IO: " + ioe.getMessage());
        } finally {
            Output.close();
        }
    }

    /* ------------------------------------------------------------------ */
    /*  Utilitário: cria diretórios / FileWriter                          */
    /* ------------------------------------------------------------------ */
    private static FileWriter createWriter(String outPath) throws IOException {
        File file   = new File(outPath);
        File parent = file.getParentFile();
        if (parent != null) parent.mkdirs();   // cria pastas se faltarem
        return new FileWriter(file);
    }

    /* ================================================================== */
    /*  Nested static classes                                             */
    /* ================================================================== */

    /**
     * <b>Output</b> centraliza o {@link FileWriter} para que qualquer parte do
     * compilador possa gravar mensagens sem passar referência adiante.
     */
    static final class Output {
        private static FileWriter writer;
        private Output() { }

        /** Inicializa a saída compartilhada (é chamada apenas pelo main). */
        static void init(FileWriter w) { writer = w; }

        /**
         * Escreve uma linha e força quebra de linha {@code System.lineSeparator()}.
         * Se ocorrer erro de IO, converte para {@link UncheckedIOException} para
         * simplificar o fluxo (não há recuperação possível nesse ponto).
         */
        static void writeln(String text) {
            try {
                if (writer != null) writer.write(text + System.lineSeparator());
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }

        /** Fecha o writer silenciosamente (usado no bloco finally). */
        static void close() {
            try {
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.err.println("Falha ao fechar arquivo: " + e.getMessage());
            }
        }
    }

    /**
     * <b>ErrorListener</b> intercepta tanto erros léxicos quanto sintáticos.
     * Ao primeiro erro:
     * <ol>
     *   <li>Emite mensagem humanamente legível no arquivo de saída;</li>
     *   <li>Escreve "Fim da compilacao";</li>
     *   <li>Encerra o programa com <code>System.exit(0)</code>.</li>
     * </ol>
     */
    static final class ErrorListener extends BaseErrorListener {
        /* Instância única – evita criar vários objetos para cada fase */
        static final ErrorListener INSTANCE = new ErrorListener();
        private ErrorListener() { }

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer,
                                Object offendingSymbol,
                                int line, int charPos,
                                String msg,
                                RecognitionException ex) {

            // Se o erro envolveu um token concreto, podemos detalhar melhor
            if (offendingSymbol instanceof Token token) {
                String lexeme    = token.getText();
                String tokenName = AlgumaLexer.VOCABULARY.getDisplayName(token.getType());

                switch (tokenName) {
                    case "UNKNOWN_TOKEN" -> Output.writeln("Linha " + line + ": " + lexeme + " - simbolo nao identificado");
                    case "COMMENT_ERROR" -> Output.writeln("Linha " + line + ": comentario nao fechado");
                    case "CADEIA_ERROR"  -> Output.writeln("Linha " + line + ": cadeia literal nao fechada");
                    default -> {
                        /* EOF vem entre <>, convertemos para texto limpo */
                        if ("<EOF>".equals(lexeme)) lexeme = "EOF";
                        Output.writeln("Linha " + line + ": erro sintatico proximo a " + lexeme);
                    }
                }
            } else {
                /* Caso raro: erro não associado a Token (ex.: erro de configuração) */
                Output.writeln("Linha " + line + ": " + msg);
            }

            /* Encerramento controlado */
            Output.writeln("Fim da compilacao");
            Output.close();
            System.exit(0);
        }
    }
}