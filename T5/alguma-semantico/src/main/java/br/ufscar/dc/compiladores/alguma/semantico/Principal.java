package br.ufscar.dc.compiladores.alguma.semantico;

import java.io.File;
import java.io.PrintWriter;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

public class Principal {
    public static void main(String[] args) {
        try (PrintWriter p = new PrintWriter(new File(args[1]))) {
            CharStream cs = CharStreams.fromFileName(args[0]);
            LALexer lexer = new LALexer(cs);

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LAParser parser = new LAParser(tokens);

            LAParser.ProgramaContext arvore = parser.programa();

            LASemantico as = new LASemantico();
            as.visitPrograma(arvore);

            for (String err : Auxiliar.errosSemanticos) {
                p.println(err);
            }

            // Gerador de código
            if(Auxiliar.errosSemanticos.isEmpty()) {
                AlgumaGerador gerador = new AlgumaGerador();
                gerador.visitPrograma(arvore);
                try(PrintWriter pw = new PrintWriter(args[1])) {
                    pw.print(gerador.saida.toString());
                }
            }

            //p.println("Fim da compilacao");
            p.close();

        } catch (Exception e) {
            System.err.println(e);
        }

    }
}