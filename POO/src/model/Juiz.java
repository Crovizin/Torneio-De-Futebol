package model;

public class Juiz {

    private String nome;
    private int credencial;

    public Juiz(String nome, int credencial) {
        this.nome = nome;
        this.credencial = credencial;
    }

    public String getNome() {
        return nome;
    }

    public int getCredencial() {
        return credencial;
    }

    @Override
    public String toString() {
        return nome + " (Credencial: " + credencial + ")";
    }
}
