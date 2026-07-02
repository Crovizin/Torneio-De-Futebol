package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Grupo extends Fase{
    private List<Time> participantes;

    public Grupo(String nome) {
        super(nome);
        this.participantes = new ArrayList<>();
    }

    public void adicionarTime(Time time) {
        this.participantes.add(time);
    }

    public void gerarJogosDoGrupo() {
        if (participantes.size() == 4) {
            // Todos os 6 confrontos possíveis entre os 4 times
            adicionarPartida(new Partida(participantes.get(0), participantes.get(1)));
            adicionarPartida(new Partida(participantes.get(2), participantes.get(3)));
            adicionarPartida(new Partida(participantes.get(0), participantes.get(2)));
            adicionarPartida(new Partida(participantes.get(1), participantes.get(3)));
            adicionarPartida(new Partida(participantes.get(0), participantes.get(3)));
            adicionarPartida(new Partida(participantes.get(1), participantes.get(2)));
        }
    }
    // função polimorfismo
    
    @Override
    public List<Time> obterClassificados() {
        // Ordena 1º pelos pontos (do maior pro menor). Se empatar, ordena 2º pelo Ranking (do menor pro maior)
        participantes.sort(Comparator.comparingInt(Time::getPontos).reversed()
            .thenComparingInt(Time::getRankingCMD));
        
        List<Time> classificados = new ArrayList<>();
        classificados.add(participantes.get(0));
        classificados.add(participantes.get(1));
        
        return classificados;
    }
    // Método para imprimir os grupos
    public void mostrarGrupos() {
        System.out.println("\n" + this.nome + ":");
        for (Time t : participantes) {
            System.out.println(t.getNome());
        }
        System.out.println("\n");
    }
    
    // Método para imprimir a tabela
    public void mostrarTabela() {
        System.out.println("\n" + this.nome);
        for (Time t : participantes) {
            System.out.println(t.getNome() + " - " + t.getPontos() + " pontos");
        }
    }



    public List<Time> getParticipantes() {
        return participantes;
    }
}