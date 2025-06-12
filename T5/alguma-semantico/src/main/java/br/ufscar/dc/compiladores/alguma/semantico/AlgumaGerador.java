package br.ufscar.dc.compiladores.alguma.semantico;
import java.util.*;

import org.antlr.v4.runtime.tree.TerminalNode;

import javax.sound.midi.SysexMessage;

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
        visitVariavel(ctx.variavel());
        return null;
    }

    @Override
    public Void visitVariavel(LAParser.VariavelContext ctx) {
        String tipoTexto = ctx.tipo().getText();
        String cTipo = toCType(tipoTexto.replace("^", ""));
        EntradaTabelaDeSimbolos.Tipos tipo = Auxiliar.getType(tipoTexto);
        for (LAParser.IdentificadorContext id : ctx.identificador()) {
            if (ctx.tipo().getText().contains("registro")) {
                for (LAParser.VariavelContext sub : ctx.tipo().registro().variavel()) {
                    for (LAParser.IdentificadorContext idIns : sub.identificador()) {
                        EntradaTabelaDeSimbolos.Tipos tipoIns = Auxiliar.getType(sub.tipo().getText());
                        tabela.inserir(id.getText() + "." + idIns.getText(), tipoIns, EntradaTabelaDeSimbolos.Estrutura.VAR);
                    }
                }
            } else if (cTipo == null && tipo == null) {
                ArrayList<EntradaTabelaDeSimbolos> arg = tabela.obterPropriedadesTipo(tipoTexto);
                if (arg != null) {
                    for (EntradaTabelaDeSimbolos val : arg) {
                        tabela.inserir(id.getText() + "." + val.getNome(), val.getTipo(), EntradaTabelaDeSimbolos.Estrutura.VAR);
                    }
                }
            }
            if (id.getText().contains("[")) {
                int ini = id.getText().indexOf("[", 0);
                int end = id.getText().indexOf("]", 0);
                String tam = end - ini == 2 ? String.valueOf(id.getText().charAt(ini + 1)) : id.getText().substring(ini + 1, end - 1);
                String name = id.IDENT().get(0).getText();
                for (int i = 0; i < Integer.parseInt(tam); i++) {
                    tabela.inserir(name + "[" + i + "]", tipo, EntradaTabelaDeSimbolos.Estrutura.VAR);
                }
            } else {
                tabela.inserir(id.getText(), tipo, EntradaTabelaDeSimbolos.Estrutura.VAR);
            }
            visitTipo(ctx.tipo());
            visitIdentificador(id);
            if (cTipo.equals("char")) {
                saida.append("[80]");
            }
            saida.append(";\n");
        }

        return null;
    }

    @Override
    public Void visitDeclaracao_constante(LAParser.Declaracao_constanteContext ctx) {
        String nomeConst = ctx.IDENT().getText();
        String tipoTexto = ctx.tipo_basico().getText();
        String type = toCType(tipoTexto);
        EntradaTabelaDeSimbolos.Tipos typeVar = Auxiliar.getType(tipoTexto);
        tabela.inserir(nomeConst, typeVar, EntradaTabelaDeSimbolos.Estrutura.VAR);
        saida.append("const ").append(type).append(" ").append(ctx.IDENT().getText()).append(" = ");
        visitValor_constante(ctx.valor_constante());
        saida.append(";\n");

        return null;
    }

    @Override
    public Void visitValor_constante(LAParser.Valor_constanteContext ctx) {
        String valor = ctx.getText();

        switch (valor) {
            case "verdadeiro":
                saida.append("true"); break;
            case "falso":
                saida.append("false"); break;
            default:
                saida.append(valor); break;
        }

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

        ctx.parametros().parametro().forEach(this::visitParametro);
        saida.append(") {\n");
        ctx.corpo().declaracao_local().forEach(this::visitDeclaracao_local);
        ctx.corpo().cmd().forEach(var -> visitCmd(var));
        saida.append("}\n");

        return null;
    }

    @Override
    public Void visitParametro(LAParser.ParametroContext ctx) {
        List<LAParser.IdentificadorContext> identificadores = ctx.identificador();
        String tipoTexto = ctx.tipo_estendido().getText().replace("^", "");
        String cTipo = toCType(tipoTexto);
        EntradaTabelaDeSimbolos.Tipos tipo = Auxiliar.getType(ctx.tipo_estendido().getText());

        for (int i = 0; i < identificadores.size(); i++) {
            if (i > 0) {
                saida.append(", ");
            }
            visitTipo_estendido(ctx.tipo_estendido());
            visitIdentificador(identificadores.get(i));
            if ("char".equals(cTipo)) {
                saida.append("[80]");
            }
            tabela.inserir(identificadores.get(i).getText(), tipo, EntradaTabelaDeSimbolos.Estrutura.VAR);
        }

        return null;
    }

    @Override
    public Void visitTipo(LAParser.TipoContext ctx) {
        String texto = ctx.getText();
        String cTipo = toCType(texto.replace("^", ""));
        boolean pointer = texto.contains("^");

        if (cTipo != null) {
            saida.append(cTipo);
        } else if (ctx.registro() != null) {
            visitRegistro(ctx.registro());
        } else {
            visitTipo_estendido(ctx.tipo_estendido());
        }

        if (pointer) {
            saida.append("*");
        }

        saida.append(" ");
        return null;
    }

    @Override
    public Void visitTipo_estendido(LAParser.Tipo_estendidoContext ctx) {
        visitTipo_basico_ident(ctx.tipo_basico_ident());
        if (ctx.getText().contains("^"))
            saida.append("*");

        return null;
    }

    @Override
    public Void visitTipo_basico_ident(LAParser.Tipo_basico_identContext ctx) {
        String texto = (ctx.IDENT() != null) ? ctx.IDENT().getText() : toCType(ctx.getText().replace("^", ""));
        saida.append(texto);
        return null;
    }


    @Override
    public Void visitDeclaracao_local(LAParser.Declaracao_localContext ctx) {
        if (ctx.declaracao_variavel() != null) {
            visitDeclaracao_variavel(ctx.declaracao_variavel());
        } else if (ctx.declaracao_constante() != null) {
            visitDeclaracao_constante(ctx.declaracao_constante());
        } else if (ctx.declaracao_tipo() != null) {
            visitDeclaracao_tipo(ctx.declaracao_tipo());
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
    public Void visitIdentificador(LAParser.IdentificadorContext ctx) {
        saida.append(" ");
        int i = 0;
        for (TerminalNode id : ctx.IDENT()) {
            if (i++ > 0)
                saida.append(".");
            saida.append(id.getText());
        }
        visitDimensao(ctx.dimensao());

        return null;
    }


    @Override
    public Void visitDimensao(LAParser.DimensaoContext ctx) {
        List<LAParser.Exp_aritmeticaContext> expressoes = ctx.exp_aritmetica();

        for (LAParser.Exp_aritmeticaContext exp : expressoes) {
            saida.append('[');
            visitExp_aritmetica(exp);
            saida.append(']');
        }

        return null;
    }


    @Override
    public Void visitExp_aritmetica(LAParser.Exp_aritmeticaContext ctx) {
        List<LAParser.TermoContext> termos = ctx.termo();
        List<LAParser.Op1Context> operadores = ctx.op1();

        for (int i = 0; i < termos.size(); i++) {
            if (i > 0) {
                saida.append(operadores.get(i - 1).getText());
            }
            visitTermo(termos.get(i));
        }

        return null;
    }

    @Override
    public Void visitTermo(LAParser.TermoContext ctx) {
        List<LAParser.FatorContext> fatores = ctx.fator();
        List<LAParser.Op2Context> operadores = ctx.op2();

        for (int i = 0; i < fatores.size(); i++) {
            if (i > 0) {
                saida.append(operadores.get(i - 1).getText());
            }
            visitFator(fatores.get(i));
        }

        return null;
    }

    @Override
    public Void visitFator(LAParser.FatorContext ctx) {
        int totalParcelas = ctx.parcela().size();

        visitParcela(ctx.parcela(0));

        for (int i = 1; i < totalParcelas; i++) {
            String operador = ctx.op3(i - 1).getText();
            saida.append(operador);
            visitParcela(ctx.parcela(i));
        }

        return null;
    }

    @Override
    public Void visitParcela(LAParser.ParcelaContext ctx) {
        boolean isUnario = ctx.parcela_unario() != null;

        if (isUnario) {
            String operador = ctx.op_unario() != null ? ctx.op_unario().getText() : "";
            saida.append(operador);
            visitParcela_unario(ctx.parcela_unario());
        } else {
            saida.append(ctx.parcela_nao_unario().getText());
        }

        return null;
    }

    @Override
    public Void visitParcela_unario(LAParser.Parcela_unarioContext ctx) {
        TerminalNode id = ctx.IDENT();
        if (id != null) {
            saida.append(id.getText());
            saida.append("(");
            for (int i = 0; i < ctx.expressao().size(); i++) {
                visitExpressao(ctx.expressao(i));
                if (i < ctx.expressao().size() - 1) {
                    saida.append(", ");
                }
            }
        } else if (ctx.parenteses_expr() != null) {
            saida.append("(");
            visitExpressao(ctx.parenteses_expr().expressao());
            saida.append(")");
        } else {
            saida.append(ctx.getText());
        }

        return null;
    }

    @Override
    public Void visitCmd(LAParser.CmdContext ctx) {
        if (ctx.cmdLeia() != null) return visitCmdLeia(ctx.cmdLeia());
        if (ctx.cmdEscreva() != null) return visitCmdEscreva(ctx.cmdEscreva());
        if (ctx.cmdAtribuicao() != null) return visitCmdAtribuicao(ctx.cmdAtribuicao());
        if (ctx.cmdSe() != null) return visitCmdSe(ctx.cmdSe());
        if (ctx.cmdCaso() != null) return visitCmdCaso(ctx.cmdCaso());
        if (ctx.cmdPara() != null) return visitCmdPara(ctx.cmdPara());
        if (ctx.cmdEnquanto() != null) return visitCmdEnquanto(ctx.cmdEnquanto());
        if (ctx.cmdFaca() != null) return visitCmdFaca(ctx.cmdFaca());
        if (ctx.cmdChamada() != null) return visitCmdChamada(ctx.cmdChamada());
        if (ctx.cmdRetorne() != null) return visitCmdRetorne(ctx.cmdRetorne());

        return null;
    }

    @Override
    public Void visitCmdLeia(LAParser.CmdLeiaContext ctx) {
        for (LAParser.IdentificadorContext id : ctx.identificador()) {
            EntradaTabelaDeSimbolos.Tipos idType = tabela.verificar(id.getText());

            if (idType == EntradaTabelaDeSimbolos.Tipos.CADEIA) {
                saida.append("gets(");
                visitIdentificador(id);
                saida.append(");\n");
            } else {
                saida.append("scanf(\"");
                saida.append(selectFormat(idType));
                saida.append("\", &");
                saida.append(id.getText());
                saida.append(");\n");
            }
        }

        return null;
    }



    @Override
    public Void visitRegistro(LAParser.RegistroContext ctx) {
        saida.append("struct {\n");
        ctx.variavel().forEach(this::visitVariavel);
        saida.append("} ");

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
        saida.append("if(");
        visitExpressao(ctx.expressao());
        saida.append(") {\n");
        for (LAParser.CmdContext c : ctx.cmd()) {
            visitCmd(c);
        }
        if (ctx.cmdSenao() != null) {
            saida.append("} else {\n");
            for (LAParser.CmdContext c : ctx.cmdSenao().cmd()) {
                visitCmd(c);
            }
        }
        saida.append("}\n");
        return null;
    }

    @Override
    public Void visitCmdEnquanto(LAParser.CmdEnquantoContext ctx) {
        saida.append("while (");
        visitExpressao(ctx.expressao());
        saida.append(") {\n");
        ctx.cmd().forEach(this::visitCmd);
        saida.append("}\n");

        return null;
    }

    @Override
    public Void visitCmdPara(LAParser.CmdParaContext ctx) {
        String id = ctx.IDENT().getText();
        saida.append("for (").append(id).append(" = ");
        visitExp_aritmetica(ctx.exp_aritmetica(0));
        saida.append("; ").append(id).append(" <= ");
        visitExp_aritmetica(ctx.exp_aritmetica(1));
        saida.append("; ").append(id).append("++) {\n");
        ctx.cmd().forEach(this::visitCmd);
        saida.append("}\n");

        return null;
    }

    @Override
    public Void visitCmdFaca(LAParser.CmdFacaContext ctx) {
        saida.append("do {\n");
        for (LAParser.CmdContext c : ctx.cmd()) {
            visitCmd(c);
        }
        saida.append("} while(");
        visitExpressao(ctx.expressao());
        saida.append(");\n");
        return null;
    }

    @Override
    public Void visitCmdAtribuicao(LAParser.CmdAtribuicaoContext ctx) {
        //System.out.println("O QUE ELE TENTOU");
        //System.out.println(ctx.identificador().getText());
        EntradaTabelaDeSimbolos.Tipos tipo = tabela.verificar(ctx.identificador().getText());

        if (ctx.getText().contains("^")) {
            saida.append("*");
        }

        if (tipo == EntradaTabelaDeSimbolos.Tipos.CADEIA) {
            saida.append("strcpy(");
            visitIdentificador(ctx.identificador());
            saida.append(",").append(ctx.expressao().getText()).append(");\n");
        } else {
            visitIdentificador(ctx.identificador());
            saida.append(" = ").append(ctx.expressao().getText()).append(";\n");
        }

        return null;
    }


    @Override
    public Void visitCmdChamada(LAParser.CmdChamadaContext ctx) {
        saida.append(ctx.IDENT().getText()).append("(");
        boolean first = true;
        for (LAParser.ExpressaoContext exp : ctx.expressao()) {
            if (!first) {
                saida.append(", ");
            } else {
                first = false;
            }
            visitExpressao(exp);
        }
        saida.append(");\n");

        return null;
    }


    @Override
    public Void visitCmdRetorne(LAParser.CmdRetorneContext ctx) {
        saida.append("return ");
        if (ctx.expressao() != null) {
            visitExpressao(ctx.expressao());
        }
        saida.append(";\n");
        return null;
    }


    @Override
    public Void visitTermo_logico(LAParser.Termo_logicoContext ctx) {
        List<LAParser.Fator_logicoContext> fatores = ctx.fator_logico();

        if (!fatores.isEmpty()) {
            visitFator_logico(fatores.get(0));
        }

        for (int i = 1; i < fatores.size(); i++) {
            saida.append(" && ");
            visitFator_logico(fatores.get(i));
        }

        return null;
    }

    @Override
    public Void visitFator_logico(LAParser.Fator_logicoContext ctx) {
        if (ctx.getText().startsWith("nao")) {
            saida.append("!");
        }
        visitParcela_logica(ctx.parcela_logica());

        return null;
    }

    @Override
    public Void visitParcela_logica(LAParser.Parcela_logicaContext ctx) {
        if (ctx.exp_relacional() != null) {
            visitExp_relacional(ctx.exp_relacional());
        } else {
            String texto = ctx.getText();
            if ("verdadeiro".equals(texto)) {
                saida.append("true");
            } else {
                saida.append("false");
            }
        }

        return null;
    }

    @Override
    public Void visitExp_relacional(LAParser.Exp_relacionalContext ctx) {
        visitExp_aritmetica(ctx.exp_aritmetica(0));
        for (int i = 1; i < ctx.exp_aritmetica().size(); i++) {
            LAParser.Exp_aritmeticaContext termo = ctx.exp_aritmetica(i);
            String op = ctx.op_relacional().getText();
            String saidaStr = op.equals("=") ? " == " : op;
            saida.append(saidaStr);
            visitExp_aritmetica(termo);
        }

        return null;
    }

    @Override
    public Void visitCmdCaso(LAParser.CmdCasoContext ctx) {
        saida.append("switch (");
        visit(ctx.exp_aritmetica());
        saida.append(") {\n");
        visit(ctx.selecao());
        if (ctx.cmdSenao() != null) {
            visit(ctx.cmdSenao());
        }
        saida.append("}\n");

        return null;
    }

    @Override
    public Void visitCmdSenao(LAParser.CmdSenaoContext ctx) {
        saida.append("default:\n");
        ctx.cmd().forEach(this::visitCmd);
        saida.append("break;\n");

        return null;
    }

    @Override
    public Void visitSelecao(LAParser.SelecaoContext ctx) {
        ctx.item_selecao().forEach(var -> visitItem_selecao(var));

        return null;
    }

    @Override
    public Void visitItem_selecao(LAParser.Item_selecaoContext ctx) {
        String[] limites = ctx.constantes().getText().split("\\.\\.");
        int inicio = Integer.parseInt(limites[0]);
        int fim = (limites.length > 1) ? Integer.parseInt(limites[1]) : inicio;

        for (int i = inicio; i <= fim; i++) {
            saida.append("case ").append(i).append(":\n");
            ctx.cmd().forEach(this::visitCmd);
            saida.append("break;\n");
        }

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

    private String toCType(String input) {
        switch (input) {
            case "inteiro": return "int";
            case "real":    return "float";
            case "literal": return "char";
            case "logico":  return "int";
            default:         return null;
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

}
