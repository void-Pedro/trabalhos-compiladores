package org.ufscar;

import java.util.*;


import org.ufscar.curriculoParser.CurriculoContext;
import org.ufscar.curriculoParser.SecaoContext;
import org.ufscar.curriculoParser.DadosContext;
import org.ufscar.curriculoParser.DadoContext;
import org.ufscar.curriculoParser.ExperienciasContext;
import org.ufscar.curriculoParser.ExperienciaContext;
import org.ufscar.curriculoParser.CampoExperienciaContext;
import org.ufscar.curriculoParser.ObjetivoContext;
import org.ufscar.curriculoParser.ObjetivoCADEIAContext;
import org.ufscar.curriculoParser.IdiomasContext;
import org.ufscar.curriculoParser.IdiomaContext;
import org.ufscar.curriculoParser.EducacaoContext;
import org.ufscar.curriculoParser.FormacaoContext;
import org.ufscar.curriculoParser.CampoFormacaoContext;
import org.ufscar.curriculoParser.LinksContext;
import org.ufscar.curriculoParser.LinkContext;
import org.ufscar.curriculoParser.HabilidadesContext;
import org.ufscar.curriculoParser.HabilidadeContext;
import org.ufscar.curriculoParser.OutrosContext;
import org.ufscar.curriculoParser.OutroContext;


public class CurriculoGerador extends curriculoBaseVisitor<String>{
    private Map<String, String> educacao = new HashMap<>();
    @Override
    public String visitCurriculo(CurriculoContext ctx) {
        StringBuilder html = new StringBuilder();
        html.append("<html>\n");

        html.append("<head><style>\n");
        html.append("body {\n" +
                "  font-family: Arial, sans-serif;\n" +
                "  margin: 10px auto 40px;\n" +
                "  max-width: 800px;\n" +
                "  line-height: 1.6;\n" +
                "  background-color: #f9f9f9;\n" +
                "  color: #333;\n" +
                "  padding: 20px;\n" +
                "  border-radius: 8px;\n" +
                "  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n" +
                "}\n" +
                "\n" +
                "h1 {\n" +
                "  text-align: center;\n" +
                "  font-size: 36px;\n" +
                "  color: #2c3e50;\n" +
                "  border-bottom: 2px solid #2c3e50;\n" +
                "  padding-bottom: 10px;\n" +
                "  margin-bottom: 30px;\n" +
                "}\n" +
                "\n" +
                "h2 {\n" +
                "  color: #34495e;\n" +
                "  border-left: 5px solid #3498db;\n" +
                "  padding-left: 10px;\n" +
                "  margin-top: 30px;\n" +
                "  font-size: 24px;\n" +
                "}\n" +
                "\n" +
                "ul {\n" +
                "  list-style-type: none;\n" +
                "  padding-left: 0;\n" +
                "  margin-top: 10px;\n" +
                "}\n" +
                "\n" +
                "li {\n" +
                "  margin-bottom: 10px;\n" +
                "}\n" +
                "\n" +
                "strong {\n" +
                "  color: #2c3e50;\n" +
                "}\n" +
                "\n" +
                "a {\n" +
                "  color: #2980b9;\n" +
                "  text-decoration: none;\n" +
                "}\n" +
                "\n" +
                "a:hover {\n" +
                "  text-decoration: underline;\n" +
                "}\n" +
                "\n" +
                "@media (max-width: 600px) {\n" +
                "  body {\n" +
                "    margin: 10px;\n" +
                "    padding: 15px;\n" +
                "  }\n" +
                "\n" +
                "  h1 {\n" +
                "    font-size: 28px;\n" +
                "  }\n" +
                "\n" +
                "  h2 {\n" +
                "    font-size: 20px;\n" +
                "  }\n" +
                "}\n");
        html.append("</style></head>\n");

        html.append("<body>\n");
        html.append("<h1>Currículo").append("</h1>\n");

        for (SecaoContext secao : ctx.secao()) {
            html.append(visit(secao));
        }

        html.append("</body></html>\n");
        return html.toString();
    }

    @Override
    public String visitDados(DadosContext ctx) {
        StringBuilder html = new StringBuilder("<h2>Dados Pessoais</h2><ul>\n");

        for (DadoContext d : ctx.dado()) {
            html.append(visitDado(d));
        }

        html.append("</ul>\n");
        return html.toString();
    }

    @Override
    public String visitDado(DadoContext ctx) {
        StringBuilder html = new StringBuilder("<li>");

        if (ctx.NOME() != null) {
            String nome = ctx.CADEIA().getText().replace("\"", "");
            html.append("<strong>Nome:</strong> ").append(nome).append("<br />\n");
        } else if (ctx.IDADE() != null) {
            String idade = ctx.NUM().getText();
            html.append("<strong>Idade:</strong> ").append(idade).append("<br />\n");
        } else if (ctx.EMAIL() != null) {
            String email = ctx.CADEIA().getText().replace("\"", "");
            html.append("<strong>Email:</strong> ").append(email).append("<br />\n");
        } else if (ctx.TELEFONE() != null) {
            String telefone = "";
            if(ctx.CADEIA() == null) {
                telefone = ctx.NUM().getText();
            } else {
                telefone = ctx.CADEIA().getText().replace("\"", "");
            }
            html.append("<strong>Telefone:</strong> ").append(telefone).append("<br />\n");
        } else if (ctx.CIDADE() != null) {
            String cidade = ctx.CADEIA().getText().replace("\"", "");
            html.append("<strong>Cidade:</strong> ").append(cidade).append("<br />\n");
        }

        html.append("</li>\n");
        return html.toString();
    }


    @Override
    public String visitExperiencias(ExperienciasContext ctx) {
        StringBuilder html = new StringBuilder("<h2>Experiências</h2><ul>\n");

        for (ExperienciaContext exp : ctx.experiencia()) {
            html.append(visitExperiencia(exp));
        }

        html.append("</ul>\n");
        return html.toString();
    }

    @Override
    public String visitExperiencia(ExperienciaContext ctx) {
        StringBuilder html = new StringBuilder("<li>\n");
        for (CampoExperienciaContext campoCtx : ctx.campoExperiencia()) {
            if (campoCtx.CARGO() != null) {
                String cargo = campoCtx.CADEIA().getText().replace("\"", "");
                html.append("<strong>Cargo:</strong> ").append(cargo).append("<br />\n");
            } else if (campoCtx.LOCALIZACAO() != null) {
                String localizacao = campoCtx.CADEIA().getText().replace("\"", "");
                html.append("<strong>Localização:</strong> ").append(localizacao).append("<br />\n");
            } else if (campoCtx.EMPRESA() != null) {
                String empresa = campoCtx.CADEIA().getText().replace("\"", "");
                html.append("<strong>Empresa:</strong> ").append(empresa).append("<br />\n");
            } else if (campoCtx.CONCLUSAO() != null) {
                String conclusao = campoCtx.CADEIA().getText().replace("\"", "");
                html.append("<strong>Conclusão:</strong> ").append(conclusao).append("<br />\n");
            }
        }
        html.append("</li>\n");
        return html.toString();
    }

    @Override
    public String visitObjetivo(ObjetivoContext ctx) {
        StringBuilder html = new StringBuilder("<h2>Objetivos</h2><ul>\n");

        for (ObjetivoCADEIAContext t : ctx.objetivoCADEIA()) {
            html.append("<li>").append(t.CADEIA().getText().replace("\"", "").trim()).append("</li>\n");
        }

        html.append("</ul>\n");
        return html.toString();
    }

    @Override
    public String visitIdiomas(IdiomasContext ctx) {
        StringBuilder html = new StringBuilder("<h2>Idiomas</h2><ul>\n");

        for (IdiomaContext lang : ctx.idioma()) {
            html.append(visitIdioma(lang));
        }

        html.append("</ul>\n");
        return html.toString();
    }

    @Override
    public String visitIdioma(IdiomaContext ctx) {
        StringBuilder html = new StringBuilder("<li>");

        if (ctx.LINGUA() != null) {
            String nomeIdioma = ctx.CADEIA().getText().replace("\"", "");
            html.append("<strong>Idioma:</strong> ").append(nomeIdioma).append("<br />\n");
        } else if (ctx.NIVEL() != null) {
            String nivel = ctx.CADEIA().getText().replace("\"", "");
            html.append("<strong>Nível:</strong> ").append(nivel).append("<br />\n");
        }

        html.append("</li>\n");
        return html.toString();
    }

    @Override
    public String visitEducacao(EducacaoContext ctx) {
        StringBuilder html = new StringBuilder("<h2>Educação</h2><ul>\n");

        for (FormacaoContext f : ctx.formacao()) {
            html.append(visitFormacao(f));
        }
        html.append("</ul>\n");
        return html.toString();
    }

    @Override
    public String visitFormacao(FormacaoContext ctx) {
        educacao.clear();
        StringBuilder html = new StringBuilder("<li>\n");

        for (CampoFormacaoContext campoCtx : ctx.campoFormacao()) {
            visitCampoFormacao(campoCtx);
        }

        String nivel = educacao.getOrDefault("nivel", "");
        String curso = educacao.getOrDefault("curso", "");
        String instituicao = educacao.getOrDefault("instituicao", "");
        String localizacao = educacao.getOrDefault("localizacao", "");
        String conclusao = educacao.getOrDefault("conclusao", "");
        html.append(nivel).append(" - ").append(curso).append(" - ").append(instituicao);
        if (!localizacao.isEmpty()) {
            html.append(" - ").append(localizacao);
        }
        if (!conclusao.isEmpty()) {
            html.append(" (").append(conclusao).append(")<br />\n");
        }

        html.append("</li>\n");
        return html.toString();
    }

    @Override
    public String visitCampoFormacao(CampoFormacaoContext ctx) {
        if (ctx.CURSO() != null) {
            String curso = ctx.CADEIA().getText().replace("\"", "");
            educacao.put("curso", curso);
        } else if (ctx.INSTITUICAO() != null) {
            String instituicao = ctx.CADEIA().getText().replace("\"", "");
            educacao.put("instituicao", instituicao);
        } else if (ctx.LOCALIZACAO() != null) {
            String localizacao = ctx.CADEIA().getText().replace("\"", "");
            educacao.put("localizacao", localizacao);
        } else if (ctx.CONCLUSAO() != null) {
            String conclusao = ctx.CADEIA().getText().replace("\"", "");
            educacao.put("conclusao", conclusao);
        } else if (ctx.NIVEL() != null) {
            String nivel = ctx.CADEIA().getText().replace("\"", "");
            educacao.put("nivel", nivel);
        }
        return "";
    }

    @Override
    public String visitLinks(LinksContext ctx) {
        StringBuilder html = new StringBuilder("<h2>Links</h2><ul>\n");

        for (LinkContext l : ctx.link()) {
            html.append("<li><a href=\"").append(l.getText().replace("\"", "").replace("-", "").trim()).append("\">")
                    .append(l.getText().replace("\"", "").replace("-", "").trim()).append("</a></li>\n");
        }

        html.append("</ul>\n");
        return html.toString();
    }

    @Override
    public String visitHabilidades(HabilidadesContext ctx) {
        StringBuilder html = new StringBuilder("<h2>Habilidades</h2><ul>\n");

        for (HabilidadeContext h : ctx.habilidade()) {
            html.append("<li>").append(h.getText().replace("-", "").replace("\"", "").trim()).append("</li>\n");
        }

        html.append("</ul>\n");
        return html.toString();
    }

    @Override
    public String visitOutros(OutrosContext ctx) {
        StringBuilder html = new StringBuilder("<h2>Outros</h2><ul>\n");

        for (OutroContext o : ctx.outro()) {
            html.append("<li>").append(o.getText().replace("-", "").replace("\"", "").trim()).append("</li>\n");
        }

        html.append("</ul>\n");
        return html.toString();
    }

}
