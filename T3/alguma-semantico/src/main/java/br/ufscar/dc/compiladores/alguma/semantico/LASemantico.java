package br.ufscar.dc.compiladores.alguma.semantico;
 
import java.util.Iterator;

import br.ufscar.dc.compiladores.alguma.semantico.LAParser.CmdAtribuicaoContext;
import br.ufscar.dc.compiladores.alguma.semantico.LAParser.Declaracao_constanteContext;
import br.ufscar.dc.compiladores.alguma.semantico.LAParser.Declaracao_globalContext;
import br.ufscar.dc.compiladores.alguma.semantico.LAParser.Declaracao_variavelContext;
import br.ufscar.dc.compiladores.alguma.semantico.LAParser.IdentificadorContext;
import br.ufscar.dc.compiladores.alguma.semantico.LAParser.Tipo_basico_identContext;

public class LASemantico extends LABaseVisitor<Object> {

    Escopo escopos = new Escopo();

    @Override
    public Object visitCorpo(LAParser.CorpoContext ctx) {
        Iterator<LAParser.CmdContext> iterator = ctx.cmd().iterator();

        // Cria o escopo utilizado na função principal
        while (iterator.hasNext()) {
            LAParser.CmdContext cmd = iterator.next();
            if (cmd.cmdRetorne() != null) {
                Auxiliar.adicionarErroSemantico(cmd.getStart(), "comando retorne nao permitido nesse escopo");
            }
        }

        return super.visitCorpo(ctx);
    }

    // Verifica se uma constante já foi declarada e, se não, insere seu tipo na tabela de símbolos.
    @Override
    public Object visitDeclaracao_constante(Declaracao_constanteContext ctx) {
        TabelaDeSimbolos atual = escopos.obterEscopoAtual();
        if (atual.possui(ctx.IDENT().getText())) {
            Auxiliar.adicionarErroSemantico(ctx.start, "constante" + ctx.IDENT().getText()
                    + " ja declarado anteriormente");
        } else {
            EntradaTabelaDeSimbolos.Tipos tipo = EntradaTabelaDeSimbolos.Tipos.INT;
            switch (ctx.tipo_basico().getText()) {
                case "logico":
                    tipo = EntradaTabelaDeSimbolos.Tipos.LOGICO;
                    break;
                case "literal":
                    tipo = EntradaTabelaDeSimbolos.Tipos.CADEIA;
                    break;
                case "real":
                    tipo = EntradaTabelaDeSimbolos.Tipos.REAL;
                    break;
                case "inteiro":
                    tipo = EntradaTabelaDeSimbolos.Tipos.INT;
                    break;

            }
            atual.inserir(ctx.IDENT().getText(), tipo);
        }

        return super.visitDeclaracao_constante(ctx);
    }

    // Verifica se uma variável já foi declarada e, se não, insere seu tipo na tabela de símbolos.
    @Override
    public Object visitDeclaracao_variavel(Declaracao_variavelContext ctx) {
        TabelaDeSimbolos atual = escopos.obterEscopoAtual();
        Iterator<IdentificadorContext> iterator = ctx.variavel().identificador().iterator();

        while (iterator.hasNext()) {
            IdentificadorContext id = iterator.next();
            if (atual.possui(id.getText())) {
                Auxiliar.adicionarErroSemantico(id.start, "identificador " + id.getText()
                        + " ja declarado anteriormente");
            } else {
                EntradaTabelaDeSimbolos.Tipos tipo = EntradaTabelaDeSimbolos.Tipos.INT;
                switch (ctx.variavel().tipo().getText()) {
                    case "literal":
                        tipo = EntradaTabelaDeSimbolos.Tipos.CADEIA;
                        break;
                    case "inteiro":
                        tipo = EntradaTabelaDeSimbolos.Tipos.INT;
                        break;
                    case "real":
                        tipo = EntradaTabelaDeSimbolos.Tipos.REAL;
                        break;
                    case "logico":
                        tipo = EntradaTabelaDeSimbolos.Tipos.LOGICO;
                        break;
                }
                atual.inserir(id.getText(), tipo);
            }
        }
        return super.visitDeclaracao_variavel(ctx);
    }
    
    // Verifica se uma função ou procedimento já foi declarado e, se não, registra seu identificador na tabela de símbolos.
    @Override
    public Object visitDeclaracao_global(Declaracao_globalContext ctx) {
        TabelaDeSimbolos escopoAtual = escopos.obterEscopoAtual();
        String nomeIdentificador = ctx.IDENT().getText();

        if (escopoAtual.possui(nomeIdentificador)) {
            Auxiliar.adicionarErroSemantico(ctx.start, nomeIdentificador + " já declarado anteriormente");
        } else {
            escopoAtual.inserir(nomeIdentificador, EntradaTabelaDeSimbolos.Tipos.TIPO);
        }

        return super.visitDeclaracao_global(ctx);
    }

    // Verifica se o tipo básico identificado foi declarado em algum escopo, emite erro se não encontrado
    @Override
    public Object visitTipo_basico_ident(Tipo_basico_identContext contextoTB) {
        if (contextoTB.IDENT() != null) {
            String nomeTipo = contextoTB.IDENT().getText();
            
            boolean tipoDeclarado = escopos.percorrerEscoposAninhados().stream()
                .anyMatch(escopo -> escopo.possui(nomeTipo));

            if (!tipoDeclarado) {
                Auxiliar.adicionarErroSemantico(contextoTB.start, "tipo " + nomeTipo + " nao declarado");
            }
        }
        return super.visitTipo_basico_ident(contextoTB);
    }

    // Verifica se o identificador foi declarado em algum escopo anterior, emite erro se não encontrado
    @Override
    public Object visitIdentificador(IdentificadorContext contextoTB) {
        String nomeIdent = contextoTB.IDENT(0).getText();
        
        boolean identDeclarado = escopos.percorrerEscoposAninhados().stream()
                .anyMatch(escopo -> escopo.possui(nomeIdent));
        
        if (!identDeclarado) {
            Auxiliar.adicionarErroSemantico(contextoTB.start, "identificador " + nomeIdent + " nao declarado");
        }

        return super.visitIdentificador(contextoTB);
    }


    // Verifica se a atribuição é válida e se a expressão da atribuição tem o mesmo tipo que a variável ou é compatível com ela, se não for, emite erro
    @Override
    public Object visitCmdAtribuicao(CmdAtribuicaoContext ctx) {
        EntradaTabelaDeSimbolos.Tipos tipoExpr = Auxiliar.verificarTipo(escopos, ctx.expressao());
        
        if (tipoExpr == EntradaTabelaDeSimbolos.Tipos.INVALIDO) {
            Auxiliar.adicionarErroSemantico(ctx.identificador().start, "atribuicao nao compativel para " + ctx.identificador().getText());
            return super.visitCmdAtribuicao(ctx);
        }

        // Verifica se a variável existe no escopo e compara os tipos
        String var = ctx.identificador().getText();
        boolean tipoCompatível = escopos.percorrerEscoposAninhados().stream()
                .anyMatch(escopo -> {
                    if (escopo.possui(var)) {
                        EntradaTabelaDeSimbolos.Tipos tipoVar = Auxiliar.verificarTipo(escopos, var);
                        boolean varNumerico = tipoVar == EntradaTabelaDeSimbolos.Tipos.REAL || tipoVar == EntradaTabelaDeSimbolos.Tipos.INT;
                        boolean exprNumerica = tipoExpr == EntradaTabelaDeSimbolos.Tipos.REAL || tipoExpr == EntradaTabelaDeSimbolos.Tipos.INT;
                        return (varNumerico && exprNumerica) || tipoVar == tipoExpr;
                    }
                    return false;
                });

        if (!tipoCompatível) {
            Auxiliar.adicionarErroSemantico(ctx.identificador().start, "atribuicao nao compativel para " + var);
        }

        return super.visitCmdAtribuicao(ctx);
    }


}