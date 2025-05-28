package br.ufscar.dc.compiladores.alguma.semantico;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

import br.ufscar.dc.compiladores.alguma.semantico.LAParser.FatorContext;
import br.ufscar.dc.compiladores.alguma.semantico.LAParser.ParcelaContext;
import br.ufscar.dc.compiladores.alguma.semantico.LAParser.TermoContext;

import java.util.Iterator;

public class Auxiliar {
    public static List<String> errosSemanticos = new ArrayList<>();

    // Adiciona um erro semântico à lista com a linha e mensagem especificada
    public static void adicionarErroSemantico(Token token, String mensagemErro) {
        int linhaErro = token.getLine();
        errosSemanticos.add(String.format("Linha %d: %s", linhaErro, mensagemErro));
    }

    // Determina o tipo de uma expressão usando a tabela de símbolos
    public static EntradaTabelaDeSimbolos.Tipos verificarTipo(Escopo contextoEscopos, LAParser.ExpressaoContext contextoExpr) {
        EntradaTabelaDeSimbolos.Tipos tipoResultado = null;

        for (LAParser.Termo_logicoContext termo : contextoExpr.termo_logico()) {
            EntradaTabelaDeSimbolos.Tipos tipoAtual = verificarTipo(contextoEscopos, termo);

            if (tipoResultado == null) {
                tipoResultado = tipoAtual;
            } else if (!tipoResultado.equals(tipoAtual) && tipoAtual != EntradaTabelaDeSimbolos.Tipos.INVALIDO) {
                tipoResultado = EntradaTabelaDeSimbolos.Tipos.INVALIDO;
            }
        }

        return tipoResultado != null ? tipoResultado : EntradaTabelaDeSimbolos.Tipos.INVALIDO;
    }

    // Determina o tipo de um termo lógico usando a tabela de símbolos
    public static EntradaTabelaDeSimbolos.Tipos verificarTipo(Escopo contextoEscopos, LAParser.Termo_logicoContext contextoTermoLogico) {
        EntradaTabelaDeSimbolos.Tipos tipoResultado = null;

        for (LAParser.Fator_logicoContext fator : contextoTermoLogico.fator_logico()) {
            EntradaTabelaDeSimbolos.Tipos tipoAtual = verificarTipo(contextoEscopos, fator);

            if (tipoResultado == null) {
                tipoResultado = tipoAtual;
            } else if (!tipoResultado.equals(tipoAtual) && tipoAtual != EntradaTabelaDeSimbolos.Tipos.INVALIDO) {
                tipoResultado = EntradaTabelaDeSimbolos.Tipos.INVALIDO;
            }
        }

        return tipoResultado != null ? tipoResultado : EntradaTabelaDeSimbolos.Tipos.INVALIDO;
    }

    // Determina o tipo de um fator lógico usando a tabela de símbolos
    public static EntradaTabelaDeSimbolos.Tipos verificarTipo(Escopo contextoEscopos, LAParser.Fator_logicoContext contextoFatorLogico) {
        return verificarTipo(contextoEscopos, contextoFatorLogico.parcela_logica());
    }

    // Determina o tipo de uma parcela lógica usando a tabela de símbolos
    public static EntradaTabelaDeSimbolos.Tipos verificarTipo(Escopo contextoEscopos, LAParser.Parcela_logicaContext contextoParcelaLogica) {
        EntradaTabelaDeSimbolos.Tipos tipoResultado = null;
        if (contextoParcelaLogica.exp_relacional() != null) {
            tipoResultado = verificarTipo(contextoEscopos, contextoParcelaLogica.exp_relacional());
        } else {
            tipoResultado = EntradaTabelaDeSimbolos.Tipos.LOGICO;
        }
        return tipoResultado;
    }

    // Determina o tipo de uma expressão relacional usando a tabela de símbolos
    public static EntradaTabelaDeSimbolos.Tipos verificarTipo(Escopo contextoEscopos, LAParser.Exp_relacionalContext contextoExprRel) {
        if (contextoExprRel.op_relacional() != null) {
            EntradaTabelaDeSimbolos.Tipos tipoResultado = null;

            for (LAParser.Exp_aritmeticaContext exp : contextoExprRel.exp_aritmetica()) {
                EntradaTabelaDeSimbolos.Tipos tipoAtual = verificarTipo(contextoEscopos, exp);
                boolean tipoAtualNumerico = tipoAtual == EntradaTabelaDeSimbolos.Tipos.INT || tipoAtual == EntradaTabelaDeSimbolos.Tipos.REAL;
                boolean tipoResultadoNumerico = tipoResultado == EntradaTabelaDeSimbolos.Tipos.INT || tipoResultado == EntradaTabelaDeSimbolos.Tipos.REAL;

                if (tipoResultado == null) {
                    tipoResultado = tipoAtual;
                } else if (!(tipoAtualNumerico && tipoResultadoNumerico) && !tipoAtual.equals(tipoResultado)) {
                    return EntradaTabelaDeSimbolos.Tipos.INVALIDO;
                }
            }

            return EntradaTabelaDeSimbolos.Tipos.LOGICO;
        } else {
            return verificarTipo(contextoEscopos, contextoExprRel.exp_aritmetica(0));
        }
    }

    // Determina o tipo de uma expressão aritmética usando a tabela de símbolos
    public static EntradaTabelaDeSimbolos.Tipos verificarTipo(Escopo escopos, LAParser.Exp_aritmeticaContext ctx) {
        EntradaTabelaDeSimbolos.Tipos retTipo = null;
        int i = 0;
        while (i < ctx.termo().size()) {
            TermoContext ta = ctx.termo(i);
            EntradaTabelaDeSimbolos.Tipos aux = verificarTipo(escopos, ta);
            if (retTipo == null) {
                retTipo = aux;
            } else if (retTipo != aux && aux != EntradaTabelaDeSimbolos.Tipos.INVALIDO) {
                retTipo = EntradaTabelaDeSimbolos.Tipos.INVALIDO;
            }
            i++;
        }

        return retTipo;
    }

    // Determina o tipo de um termo usando a tabela de símbolos
    public static EntradaTabelaDeSimbolos.Tipos verificarTipo(Escopo contextoEscopos, LAParser.TermoContext contextoTermo) {
        EntradaTabelaDeSimbolos.Tipos tipoResultado = null;

        Iterator<FatorContext> iterFator = contextoTermo.fator().iterator();
        while (iterFator.hasNext()) {
            FatorContext fatorAtual = iterFator.next();
            EntradaTabelaDeSimbolos.Tipos tipoAux = verificarTipo(contextoEscopos, fatorAtual);
            Boolean auxNumerico = tipoAux == EntradaTabelaDeSimbolos.Tipos.REAL || tipoAux == EntradaTabelaDeSimbolos.Tipos.INT;
            Boolean resultadoNumerico = tipoResultado == EntradaTabelaDeSimbolos.Tipos.REAL || tipoResultado == EntradaTabelaDeSimbolos.Tipos.INT;
            if (tipoResultado == null) {
                tipoResultado = tipoAux;
            } else if (!(auxNumerico && resultadoNumerico) && tipoAux != tipoResultado) {
                tipoResultado = EntradaTabelaDeSimbolos.Tipos.INVALIDO;
            }
        }
        return tipoResultado;
    }

    // Determina o tipo de um fator usando a tabela de símbolos
    public static EntradaTabelaDeSimbolos.Tipos verificarTipo(Escopo contextoEscopos, LAParser.FatorContext contextoFator) {
        EntradaTabelaDeSimbolos.Tipos tipoResultado = null;

        Iterator<ParcelaContext> iterParcela = contextoFator.parcela().iterator();
        while (iterParcela.hasNext()) {
            ParcelaContext parcelaAtual = iterParcela.next();
            EntradaTabelaDeSimbolos.Tipos tipoAux = verificarTipo(contextoEscopos, parcelaAtual);
            if (tipoResultado == null) {
                tipoResultado = tipoAux;
            } else if (tipoResultado != tipoAux && tipoAux != EntradaTabelaDeSimbolos.Tipos.INVALIDO) {
                tipoResultado = EntradaTabelaDeSimbolos.Tipos.INVALIDO;
            }
        }
        return tipoResultado;
    }

    // Determina o tipo de uma parcela usando a tabela de símbolos
    public static EntradaTabelaDeSimbolos.Tipos verificarTipo(Escopo contextoEscopos, LAParser.ParcelaContext contextoParcela) {
        EntradaTabelaDeSimbolos.Tipos tipoResultado = EntradaTabelaDeSimbolos.Tipos.INVALIDO;

        if (contextoParcela.parcela_nao_unario() != null) {
            tipoResultado = verificarTipo(contextoEscopos, contextoParcela.parcela_nao_unario());
        } else {
            tipoResultado = verificarTipo(contextoEscopos, contextoParcela.parcela_unario());
        }
        return tipoResultado;
    }

    // Determina o tipo de uma parcela não unária usando a tabela de símbolos
    public static EntradaTabelaDeSimbolos.Tipos verificarTipo(Escopo contextoEscopos, LAParser.Parcela_nao_unarioContext contextoParcelaNaoUnario) {
        if (contextoParcelaNaoUnario.identificador() != null) {
            return verificarTipo(contextoEscopos, contextoParcelaNaoUnario.identificador());
        }
        return EntradaTabelaDeSimbolos.Tipos.CADEIA;
    }

    // Determina o tipo de um identificador usando a tabela de símbolos
    public static EntradaTabelaDeSimbolos.Tipos verificarTipo(Escopo contextoEscopos, LAParser.IdentificadorContext contextoIdentificador) {
        StringBuilder nomeVar = new StringBuilder();

        // Concatena os identificadores usando "." como separador
        for (int i = 0; i < contextoIdentificador.IDENT().size(); i++) {
            nomeVar.append(contextoIdentificador.IDENT(i).getText());
            if (i != contextoIdentificador.IDENT().size() - 1) {
                nomeVar.append(".");
            }
        }

        // Percorre os escopos para verificar se o identificador existe. Retorna inválido se não encontrar
        for (TabelaDeSimbolos tabelaAtual : contextoEscopos.percorrerEscoposAninhados()) {
            if (tabelaAtual.possui(nomeVar.toString())) {
                return verificarTipo(contextoEscopos, nomeVar.toString());
            }
        }
        return EntradaTabelaDeSimbolos.Tipos.INVALIDO;
    }

    // Retorna o tipo de uma parcela unária
    public static EntradaTabelaDeSimbolos.Tipos verificarTipo(
            Escopo escopos,
            LAParser.Parcela_unarioContext ctx
    ) {
        // Verifica se não é identificador
        if (ctx.identificador() != null) {
            return verificarTipo(escopos, ctx.identificador());
        }

        // Literais numéricos
        if (ctx.NUM_REAL() != null) {
            return EntradaTabelaDeSimbolos.Tipos.REAL;
        }
        if (ctx.NUM_INT() != null) {
            return EntradaTabelaDeSimbolos.Tipos.INT;
        }

        // IDENT sozinho: trata como chamada de variável/tipo
        if (ctx.IDENT() != null) {
            return verificarTipo(escopos, ctx.IDENT().getText());
        }

        // Caso composto (expressões entre parênteses ou chamadas): reduz todos os tipos
        EntradaTabelaDeSimbolos.Tipos resultado = null;
        for (LAParser.ExpressaoContext expr : ctx.expressao()) {
            EntradaTabelaDeSimbolos.Tipos tipoExpr = verificarTipo(escopos, expr);
            if (resultado == null) {
                resultado = tipoExpr;
            } else if (resultado != tipoExpr
                    && tipoExpr != EntradaTabelaDeSimbolos.Tipos.INVALIDO) {
                resultado = EntradaTabelaDeSimbolos.Tipos.INVALIDO;
            }
        }
        return resultado;
    }

    public static EntradaTabelaDeSimbolos.Tipos getType(String val) {
        EntradaTabelaDeSimbolos.Tipos tipo = null;
        switch (val) {
            case "real":
                tipo = EntradaTabelaDeSimbolos.Tipos.REAL;
                break;
            case "inteiro":
                tipo = EntradaTabelaDeSimbolos.Tipos.INT;
                break;
            case "logico":
                tipo = EntradaTabelaDeSimbolos.Tipos.LOGICO;
                break;
            case "literal":
                tipo = EntradaTabelaDeSimbolos.Tipos.CADEIA;
                break;
            default:
                break;
        }
        return tipo;
    }

    // Determina o tipo de uma string recebida utilizando a tabela de símbolos
    public static EntradaTabelaDeSimbolos.Tipos verificarTipo(Escopo contextoEscopos, String nomeVar) {
        for (TabelaDeSimbolos tabela : contextoEscopos.percorrerEscoposAninhados()) {
            EntradaTabelaDeSimbolos.Tipos tipo = tabela.verificar(nomeVar);
            if (tipo != null) {
                return tipo;
            }
        }
        return EntradaTabelaDeSimbolos.Tipos.INVALIDO;
    }

}