package model;

public class Time {

    private String nome;
    private int rankingCMD;
    private int pontos;

    // Novos atributos
    private String pais;
    private String curiosidade;
    private String resumo;
    private double chanceTitulo;

    // Construtor antigo (permanece igual)
    public Time(String nome, int rankingCMD) {
        this.nome = nome;
        this.rankingCMD = rankingCMD;
        this.pontos = 0;
    }

    // Novo construtor (para carregar do banco)
    public Time(String nome,
                String pais,
                int rankingCMD,
                String curiosidade,
                String resumo,
                double chanceTitulo) {

        this.nome = nome;
        this.pais = pais;
        this.rankingCMD = rankingCMD;
        this.curiosidade = curiosidade;
        this.resumo = resumo;
        this.chanceTitulo = chanceTitulo;
        this.pontos = 0;
    }

    public void adicionarPontos(int valor) {
        this.pontos += valor;
    }

    public String getNome() {
        return nome;
    }

    public int getRankingCMD() {
        return rankingCMD;
    }

    public int getPontos() {
        return pontos;
    }

    // Novos getters
    public String getPais() {
        return pais;
    }

    public String getCuriosidade() {
        return curiosidade;
    }

    public String getResumo() {
        return resumo;
    }

    public double getChanceTitulo() {
        return chanceTitulo;
    }
}