package br.ufscar.dc.compiladores.alguma.semantico;

import java.util.ArrayList;
import java.util.HashMap;

import br.ufscar.dc.compiladores.alguma.semantico.EntradaTabelaDeSimbolos.Tipos;

public class TabelaDeSimbolos {
    public EntradaTabelaDeSimbolos.Tipos tipoRetorno;

    private HashMap<String, EntradaTabelaDeSimbolos> tabelaDeSimbolos;
    private HashMap<String, ArrayList<EntradaTabelaDeSimbolos>> tabelaTipos;

    public TabelaDeSimbolos(EntradaTabelaDeSimbolos.Tipos tipoRetorno) {
        tabelaDeSimbolos = new HashMap<>();
        tabelaTipos = new HashMap<>();
        this.tipoRetorno = tipoRetorno;
    }

    public void inserir(String name, EntradaTabelaDeSimbolos.Tipos tipo, EntradaTabelaDeSimbolos.Estrutura estrutura) {
        EntradaTabelaDeSimbolos input = new EntradaTabelaDeSimbolos(name, tipo, estrutura);
        tabelaDeSimbolos.put(name, input);
    }

    public void inserir(EntradaTabelaDeSimbolos input) {
        tabelaDeSimbolos.put(input.name, input);
    }

    public void inserir(String tipoName, EntradaTabelaDeSimbolos input) {
        if (tabelaTipos.containsKey(tipoName)) {
            tabelaTipos.get(tipoName).add(input);
        } else {
            ArrayList<EntradaTabelaDeSimbolos> list = new ArrayList<>();
            list.add(input);
            tabelaTipos.put(tipoName, list);
        }
    }

    public Tipos verificar(String nome){
        return tabelaDeSimbolos.get(nome).tipo;
    }

    public boolean possui(String nome){
        return tabelaDeSimbolos.containsKey(nome);
    }

    public ArrayList<EntradaTabelaDeSimbolos> obterPropriedadesTipo(String name) {
        return tabelaTipos.get(name);
    }

}