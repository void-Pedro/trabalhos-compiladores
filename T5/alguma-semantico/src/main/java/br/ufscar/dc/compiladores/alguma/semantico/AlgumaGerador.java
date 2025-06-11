package br.ufscar.dc.compiladores.alguma.semantico;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class AlgumaGerador extends LABaseVisitor<Void> {
    StringBuilder saida;
    TabelaDeSimbolos tabela;
    private Map<String, String> tipos = new HashMap<>();

    public String getSaida() {
        return saida.toString();
    }

    public AlgumaGerador() {
        saida = new StringBuilder();
        this.tabela = new TabelaDeSimbolos();
    }

    @Override
    public Void visitPrograma(LAParser.ProgramaContext ctx) {
        saida.append("#include <stdio.h>\n");
        saida.append("#include <stdlib.h>\n\n");
        visitDeclaracoes(ctx.declaracoes());
        saida.append("int main() {\n");
        visitCorpo(ctx.corpo());
        saida.append("return 0;\n");
        saida.append("}\n");
        return null;
    }

    @Override
    public Void visitDeclaracoes(LAParser.DeclaracoesContext ctx) {
        List<LAParser.Declaracao_localContext> locals = ctx.declaracao_local();
        for (LAParser.Declaracao_localContext d : locals) {
            visitDeclaracao_local(d);
        }
        List<LAParser.Declaracao_globalContext> globals = ctx.declaracao_global();
        for (LAParser.Declaracao_globalContext g : globals) {
            visitDeclaracao_global(g);
        }
        return null;
    }

    @Override
    public Void visitDeclaracao_variavel(LAParser.Declaracao_variavelContext ctx) {
        String tipoC = toCType(ctx.variavel().tipo());
        List<LAParser.IdentificadorContext> ids = ctx.variavel().identificador();
        for (LAParser.IdentificadorContext idCtx : ids) {
            String name = idCtx.IDENT().getFirst().getText();
            String dims = idCtx.dimensao().getText();
            saida.append(tipoC + " " + name + dims + ";\n");
        }
        return null;
    }

    @Override
    public Void visitDeclaracao_constante(LAParser.Declaracao_constanteContext ctx) {
        String name = ctx.IDENT().getText();
        String val  = ctx.valor_constante().getText();
        saida.append("const " + inferConstType(val) + " " + name + " = " + val + ";\n");
        return null;
    }

    @Override
    public Void visitDeclaracao_tipo(LAParser.Declaracao_tipoContext ctx) {
        saida.append("typedef ");
        EntradaTabelaDeSimbolos.Tipos tipo = Auxiliar.getType(ctx.tipo().getText());
        if (ctx.tipo().getText().contains("registro")) {
            for (LAParser.VariavelContext sub : ctx.tipo().registro().variavel()) {
                for (LAParser.IdentificadorContext idIns : sub.identificador()) {
                    EntradaTabelaDeSimbolos.Tipos tipoIns = Auxiliar.getType(sub.tipo().getText());
                    tabela.inserir(ctx.IDENT().getText() + "." + idIns.getText(), tipoIns, EntradaTabelaDeSimbolos.Estrutura.VAR);
                    tabela.inserir(ctx.IDENT().getText(), new EntradaTabelaDeSimbolos(idIns.getText(), tipoIns, EntradaTabelaDeSimbolos.Estrutura.TIPO));
                }
            }
        }
        tabela.inserir(ctx.IDENT().getText(), tipo, EntradaTabelaDeSimbolos.Estrutura.VAR);
        visitTipo(ctx.tipo());
        saida.append(ctx.IDENT() + ";\n");

        return null;
    }

    @Override
    public Void visitDeclaracao_global(LAParser.Declaracao_globalContext ctx) {
        if (ctx.getText().contains("procedimento")) {
            saida.append("void " + ctx.IDENT().getText() + "(");
        }
        if (ctx.getText().contains("funcao")) {
            String cTipo = toCType(ctx.tipo_estendido());
            EntradaTabelaDeSimbolos.Tipos tipo = Auxiliar.getType(ctx.tipo_estendido().getText());
            visitTipo_estendido(ctx.tipo_estendido());
            if (cTipo == "char") {
                saida.append("[80]");
            }
            saida.append(" " + ctx.IDENT().getText() + "(");
            tabela.inserir(ctx.IDENT().getText(), tipo, EntradaTabelaDeSimbolos.Estrutura.FUNC);
        }
        return null;
    }

    @Override
    public Void visitCorpo(LAParser.CorpoContext ctx) {
        List<LAParser.Declaracao_localContext> dlocs = ctx.declaracao_local();
        for (LAParser.Declaracao_localContext d : dlocs) {
            visitDeclaracao_local(d);
        }
        List<LAParser.CmdContext> cmds = ctx.cmd();
        for (LAParser.CmdContext c : cmds) {
            visitCmd(c);
        }
        return null;
    }

    @Override
    public Void visitCmdLeia(LAParser.CmdLeiaContext ctx) {
        for (LAParser.IdentificadorContext id : ctx.identificador()) {
            String name = id.getText();
            EntradaTabelaDeSimbolos.Tipos tipoC = tabela.verificar(name);
            String fmt = selectFormat(tipoC);
            saida.append("scanf(\"").append(fmt)
                    .append("\", &").append(name).append(");\n");
        }
        return null;
    }

    @Override
    public Void visitCmdEscreva(LAParser.CmdEscrevaContext ctx) {
        List<LAParser.ExpressaoContext> exps = ctx.expressao();
        for (LAParser.ExpressaoContext e : exps) {
            Escopo escopo = new Escopo(tabela);
            String abrvType = selectFormat(Auxiliar.verificarTipo(escopo, e));
            if (tabela.possui(e.getText())) {
                EntradaTabelaDeSimbolos.Tipos tipo = tabela.verificar(e.getText());
                abrvType = selectFormat(tipo);
            }
            saida.append("printf(\"" + abrvType + "\", " + e.getText() + ");\n");
        }
        return null;
    }

    @Override
    public Void visitCmdSe(LAParser.CmdSeContext ctx) {
        saida.append("if(" + ctx.expressao().getText() + ") {\n");
        for (LAParser.CmdContext c : ctx.cmd()) {
            visitCmd(c);
        }
        if (ctx.SENAO() != null) {
            saida.append("} else {\n");
            for (LAParser.CmdContext c : ctx.cmd()) {
                visitCmd(c);
            }
        }
        saida.append("}\n");
        return null;
    }

    @Override
    public Void visitCmdEnquanto(LAParser.CmdEnquantoContext ctx) {
        saida.append("while(" + ctx.expressao().getText() + ") {\n");
        for (LAParser.CmdContext c : ctx.cmd()) {
            visitCmd(c);
        }
        saida.append("}\n");
        return null;
    }

    @Override
    public Void visitCmdPara(LAParser.CmdParaContext ctx) {
        String varName = ctx.IDENT().getText();
        String start = ctx.exp_aritmetica(0).getText();
        String end = ctx.exp_aritmetica(1).getText();
        saida.append("for(" + varName + " = " + start + "; " + varName + " <= " + end + "; " + varName + "++) {\n");
        for (LAParser.CmdContext c : ctx.cmd()) {
            visitCmd(c);
        }
        saida.append("}\n");
        return null;
    }

    @Override
    public Void visitCmdFaca(LAParser.CmdFacaContext ctx) {
        saida.append("do {\n");
        for (LAParser.CmdContext c : ctx.cmd()) {
            visitCmd(c);
        }
        saida.append("} while(" + ctx.expressao().getText() + ");\n");
        return null;
    }

    @Override
    public Void visitCmdAtribuicao(LAParser.CmdAtribuicaoContext ctx) {
        saida.append(ctx.identificador().getText() + " = " + ctx.expressao().getText() + ";\n");
        return null;
    }

    @Override
    public Void visitCmdChamada(LAParser.CmdChamadaContext ctx) {
        List<LAParser.ExpressaoContext> arguments = ctx.expressao();
        StringBuilder args = new StringBuilder();
        for (int i = 0; i < arguments.size(); i++) {
            args.append(arguments.get(i).getText());
            if (i < arguments.size() - 1) args.append(", ");
        }
        saida.append(ctx.IDENT().getText() + "(" + args.toString() + ");\n");
        return null;
    }

    @Override
    public Void visitCmdRetorne(LAParser.CmdRetorneContext ctx) {
        saida.append("return " + ctx.expressao().getText() + ";\n");
        return null;
    }

    @Override
    public Void visitCmdCaso(LAParser.CmdCasoContext ctx) {
        saida.append("switch(" + ctx.exp_aritmetica().getText() + ") { ");
                List<LAParser.Item_selecaoContext> items = ctx.selecao().item_selecao();
        for (LAParser.Item_selecaoContext item : items) {
            for (LAParser.Numero_intervaloContext ni : item.constantes().numero_intervalo()) {
                saida.append("case " + ni.getText().replace("..", " ... ") + ": ");
            }
            for (LAParser.CmdContext c : item.cmd()) {
                visitCmd(c);
            }
            saida.append("break; ");
        }
        // default (senao)
        if (ctx.SENAO() != null) {
            saida.append("default: ");
            int start = items.size();
            int total = ctx.cmd().size();
            for (int i = start; i < total; i++) {
                visitCmd(ctx.cmd(i));
            }
            saida.append("break; ");
        }
        saida.append("} ");
        return null;
    }

    private String toCType(LAParser.Tipo_basicoContext ctx) {
        switch (ctx.getText()) {
            case "inteiro": return "int";
            case "real":    return "float";
            case "literal": return "char*";
            case "logico":  return "int";
            default:         return ctx.getText();
        }
        }


        // Mapeamento de identificador de tipo ou tipo básico
    private String toCType(LAParser.Tipo_basico_identContext ctx) {
        if (ctx.IDENT() != null) {
            return ctx.IDENT().getText();
        }
        return toCType(ctx.tipo_basico());
    }

    // Mapeamento de tipos estendidos (ponteiros)
    private String toCType(LAParser.Tipo_estendidoContext ctx) {
        String texto = ctx.getText();
        String base = toCType(ctx.tipo_basico_ident());
        if (texto.startsWith("^")) {
            return base + "*";
        }
        return base;
    }

    // Mapeamento de tipos complexos e registros
    private String toCType(LAParser.TipoContext ctx) {
        if (ctx.registro() != null) {
            return ctx.getText(); // já typedef
        }
        return toCType(ctx.tipo_estendido());
    }

    private String selectFormat(EntradaTabelaDeSimbolos.Tipos tipo) {
        switch (tipo) {
            case REAL:  return "%f";
            case CADEIA:  return "%s";
            default:        return "%d";
        }
    }

    private String inferConstType(String lit) {
        if (lit.matches("\\d+")) return "int";
        if (lit.matches("\\d+\\.\\d+")) return "float";
        return "char*";
    }

}
