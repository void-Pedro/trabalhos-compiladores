package br.ufscar.dc.compiladores.alguma.lexico;

import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class Principal {

    public static void main(String[] args) {
        // Verifica se dois argumentos foram fornecidos na linha de comando
        if (args.length < 2) {
            System.out.println("Devem ser fornecidos dois arquivos - entrada e saída");
            return;
        }

        // Arquivo de entrada fornecido pelo usuário
        String arquivoEntrada = args[0];
        // Arquivo de saída fornecido pelo usuário
        String arquivoSaida = args[1];

        try (PrintWriter writer = new PrintWriter(arquivoSaida)) {
            // Cria um CharStream a partir do arquivo de entrada
            CharStream cs = CharStreams.fromFileName(arquivoEntrada);
            LALexer lex = new LALexer(cs);

            Token token;
            // Loop para obter tokens até o fim do arquivo (EOF)
            while ((token = lex.nextToken()).getType() != Token.EOF) {
                // Obtém o nome simbólico do token atual
                String nomeToken = LALexer.VOCABULARY.getDisplayName(token.getType());

                // Trata casos específicos de erro léxico
                switch (nomeToken) {
                    case "COMENTARIO_NAO_FECHADO":
                        writer.printf("Linha %d: comentario nao fechado%n", token.getLine());
                        return;

                    case "ERR":
                        writer.printf("Linha %d: %s - simbolo nao identificado%n", token.getLine(), token.getText());
                        return;

                    case "CADEIA_NAO_FECHADA":
                        writer.printf("Linha %d: cadeia literal nao fechada%n", token.getLine());
                        return;

                    // Caso não possua erros
                    default:
                        writer.printf("<'%s',%s>%n", token.getText(), nomeToken);
                }
            }

        } catch (IOException ex) {
            // Mensagem de erro caso ocorra problema de IO
            System.err.println("Ocorreu um erro ao executar o analisador: " + ex.getMessage());
        }
    }
}
