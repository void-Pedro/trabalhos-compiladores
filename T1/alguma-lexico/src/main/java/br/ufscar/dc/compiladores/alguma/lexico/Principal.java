package br.ufscar.dc.compiladores.alguma.lexico;

import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class Principal {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Devem ser fornecidos dois arquivos - entrada e saída");
            return;
        }

        String arquivoEntrada = args[0];
        String arquivoSaida = args[1];

        try (PrintWriter writer = new PrintWriter(arquivoSaida)) {
            CharStream cs = CharStreams.fromFileName(arquivoEntrada);
            LALexer lex = new LALexer(cs);

            Token token;
            while ((token = lex.nextToken()).getType() != Token.EOF) {
                String nomeToken = LALexer.VOCABULARY.getDisplayName(token.getType());

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
            System.err.println("Ocorreu um erro ao executar o analisador: " + ex.getMessage());
        }
    }
}
