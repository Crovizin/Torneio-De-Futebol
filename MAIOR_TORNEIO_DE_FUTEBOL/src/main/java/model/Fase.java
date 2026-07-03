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

public void jogarFase(List<Juiz> juizes) {

    System.out.println("\n--- Rodando partidas de: " + this.nome + " ---");

    java.util.Random random = new java.util.Random();

    for (Partida p : partidas) {

        Juiz juizSorteado = juizes.get(random.nextInt(juizes.size()));

        p.setJuiz(juizSorteado);

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