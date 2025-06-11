package br.ufscar.dc.compiladores.alguma.semantico;

import java.util.LinkedList;
import java.util.List;


public class Escopo {

    private LinkedList<TabelaDeSimbolos> pilhaDeTabelas;

    public Escopo(EntradaTabelaDeSimbolos.Tipos returnType) {
        pilhaDeTabelas = new LinkedList<>();
        criarNovoEscopo(returnType);
    }

    public Escopo(TabelaDeSimbolos t) {
        pilhaDeTabelas = new LinkedList<>();
        pilhaDeTabelas.push(t);
    }

    public void criarNovoEscopo(EntradaTabelaDeSimbolos.Tipos returnType) {
        pilhaDeTabelas.push(new TabelaDeSimbolos(returnType));
    }

    public TabelaDeSimbolos obterEscopoAtual() {
        return pilhaDeTabelas.peek();
    }

    public List<TabelaDeSimbolos> percorrerEscoposAninhados() {
        return pilhaDeTabelas;
    }

    public void abandonarEscopo() {
        pilhaDeTabelas.pop();
    }
}