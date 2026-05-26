package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Fase {
    protected String nome;
    protected List<Partida> partidas;

    public Fase(String nome) {
        this.nome = nome;
        this.partidas = new ArrayList<>();
    }

    public void adicionarPartida(Partida partida) {
        this.partidas.add(partida);
    }

    public void jogarFase() {
        System.out.println("\n--- Rodando partidas de: " + this.nome + " ---");
        for (Partida p : partidas) {
            p.simularPartida();
            p.imprimirResultado(); 
        }
    }

    public String getNome() {
        return nome;
    }
    // função polimorfismo
    public abstract List<Time> obterClassificados(); 
    

}