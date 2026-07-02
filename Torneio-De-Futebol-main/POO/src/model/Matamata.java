package model;

import java.util.ArrayList;
import java.util.List;

public class Matamata extends Fase {
    private List<Time> timesRestantes;

    public Matamata(String nome, List<Time> timesRestantes) {
        super(nome); 
        this.timesRestantes = timesRestantes;
        gerarPartidas();
    }

    private void gerarPartidas() {
        
        for (int i = 0; i < timesRestantes.size(); i += 2) {
            adicionarPartida(new Partida(timesRestantes.get(i), timesRestantes.get(i + 1)));
        }
    }

    // função polimorfismo
    @Override
    public List<Time> obterClassificados() {
        List<Time> classificados = new ArrayList<>();
        
        
        for (Partida p : partidas) {
            classificados.add(p.getVencedor()); 
        }
        
        return classificados;
    }
}