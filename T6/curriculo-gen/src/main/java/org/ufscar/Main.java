package org.ufscar;

import java.io.PrintWriter;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            CharStream cs = CharStreams.fromFileName(args[0]);
            curriculoLexer lexer = new curriculoLexer(cs);
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MyCustomErrorListener());

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Comentar essa parte na versão final
            //tokens.fill();
            //printTokens(tokens);

            curriculoParser parser = new curriculoParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(new MyCustomErrorListener());

            curriculoParser.CurriculoContext arvore = parser.curriculo();

            // Adicionar o código do analisador semantico
            //CurriculoGerador visitor = new CurriculoSemantico();
            //String html = visitor.visit(arvore);

            // Criar uma classe auxiliar para armazenar erros semanticos
            //for (String err : Auxiliar.errosSemanticos) {
            //    p.println(err);
            //}

            CurriculoGerador visitor = new CurriculoGerador();
            String html = visitor.visit(arvore);

            createFile(args[1], html);
            System.out.println("Arquivo HTML gerado com sucesso: " + new File(args[1]).getAbsolutePath());

        } catch (Exception e) {
            System.err.println("Erros ao executar o código");
            System.err.println(e);
        }
    }

    private static void printTokens(CommonTokenStream tokens) {
        for (Token token : tokens.getTokens()) {
            int tipo = token.getType();
            String nomeTipo = curriculoLexer.VOCABULARY.getSymbolicName(tipo);
            System.out.println("Texto: " + token.getText() + " | Tipo: " + nomeTipo);
        }
    }

    private static void createFile(String fileName, String content) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.println(content);
        } catch (Exception e) {
            System.err.println("Erro ao criar arquivo: " + e.getMessage());
        }
    }

    private static class MyCustomErrorListener extends BaseErrorListener {
        StringBuilder errosSintaticos = new StringBuilder();
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer,
                                Object offendingSymbol,
                                int line, int charPos,
                                String msg,
                                RecognitionException ex) {

            if (offendingSymbol instanceof Token token) {
                String lexeme    = token.getText();
                String tokenName = curriculoLexer.VOCABULARY.getDisplayName(token.getType());

                switch (tokenName) {
                    case "UNKNOWN_TOKEN" -> errosSintaticos.append("Linha " + line + ": " + lexeme + " - simbolo nao identificado");
                    case "COMMENT_ERROR" -> errosSintaticos.append("Linha " + line + ": comentario nao fechado");
                    case "CADEIA_ERROR"  -> errosSintaticos.append("Linha " + line + ": cadeia literal nao fechada");
                    default -> {
                        if ("<EOF>".equals(lexeme)) lexeme = "EOF";
                        errosSintaticos.append("Linha " + line + ": erro sintatico proximo a " + lexeme);
                    }
                }
            } else {
                errosSintaticos.append("Linha " + line + ": " + msg);
            }
            errosSintaticos.append("\nFim da compilacao");
            System.out.println(errosSintaticos);
            System.out.println("Erros salvos no arquivo errosSintaticos.txt");
            createFile("errosSintaticos.txt", errosSintaticos.toString());
            System.exit(0);
        }
    }
}