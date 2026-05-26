package model;

public class Time {
    private String nome;
    private int rankingCMD; // Ex: 1 é o melhor, 32 é o pior
    private int pontos;

    public Time(String nome, int rankingCMD) {
        this.nome = nome;
        this.rankingCMD = rankingCMD;
        this.pontos = 0; // Todo time começa o torneio com 0 pontos
    }

    // Método chamado pela classe Partida para somar pontos (3 para vitória, 1 para empate)
    public void adicionarPontos(int valor) {
        this.pontos += valor;
    }

    // Getters necessários para o funcionamento do torneio
    public String getNome() { 
        return nome; 
    }
    
    public int getRankingCMD() { 
        return rankingCMD; 
    }
    
    public int getPontos() { 
        return pontos; 
    }
}