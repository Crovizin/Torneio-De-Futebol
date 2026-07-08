package model;

import java.util.Random;

public class Partida {
    private Time timeCasa;
    private Time timeVisitante;
    private int golCasa;
    private int golVisitante;
    private boolean finalizada;
    private Juiz juiz;
    
    private String eventoEspecial; 

    public Partida(Time timeCasa, Time timeVisitante) {
        this.timeCasa = timeCasa;
        this.timeVisitante = timeVisitante;
        this.finalizada = false;
        this.golCasa = 0;
        this.golVisitante = 0;
        this.eventoEspecial = "";
}
    
    public void setJuiz(Juiz juiz) {
    this.juiz = juiz;
}

public Juiz getJuiz() {
    return juiz;
}

    public void simularPartida() {
        if (finalizada) return; 

        Random random = new Random();
        

        int sorteioEspecial = random.nextInt(100); // Roda um número de 0 a 99

        if (sorteioEspecial < 2) {
            // 2% DE CHANCE: VITÓRIA POR W.O.
            boolean casaVenceWO = random.nextBoolean(); 
            
            if (casaVenceWO) {
                this.golCasa = 3;
                this.golVisitante = 0;
                this.eventoEspecial = "W.O.! O time do " + timeVisitante.getNome() + " não conseguiu chegar ao estádio!";
                timeCasa.adicionarPontos(3);
            } else {
                this.golCasa = 0;
                this.golVisitante = 3;
                this.eventoEspecial = "W.O.! O time do " + timeCasa.getNome() + " não conseguiu chegar ao estádio!";
                timeVisitante.adicionarPontos(3);
            }

        } else if (sorteioEspecial == 2) {
            
            boolean casaExpulsa = random.nextBoolean();
            
            if (casaExpulsa) {
                this.golCasa = 0;
                this.golVisitante = 3;
                this.eventoEspecial = "JOGO ENCERRADO! O " + timeCasa.getNome() + " teve 5 jogadores expulsos e perdeu de WO!";
                timeVisitante.adicionarPontos(3);
            } else {
                this.golCasa = 3;
                this.golVisitante = 0;
                this.eventoEspecial = "JOGO ENCERRADO! O " + timeVisitante.getNome() + " teve 5 jogadores expulsos e perdeu de WO!";
                timeCasa.adicionarPontos(3);
            }

        } else {
 
            int forcaCasa = 40 - timeCasa.getRankingCMD(); 
            int forcaVisitante = 40 - timeVisitante.getRankingCMD();

            this.golCasa = random.nextInt(3) + (random.nextInt(100) < forcaCasa ? 1 : 0);
            this.golVisitante = random.nextInt(3) + (random.nextInt(100) < forcaVisitante ? 1 : 0);
            
            if (random.nextInt(100) < 10) this.golCasa++;

            // Distribui os pontos
            if (this.golCasa > this.golVisitante) {
                timeCasa.adicionarPontos(3);
            } else if (this.golVisitante > this.golCasa) {
                timeVisitante.adicionarPontos(3);
            } else {
                timeCasa.adicionarPontos(1);
                timeVisitante.adicionarPontos(1);
            }
        }

        this.finalizada = true;
    }

    public Time getVencedor() {
        if (this.golCasa > this.golVisitante) {
            return timeCasa;
        } else if (this.golVisitante > this.golCasa) {
            return timeVisitante;
        } else {
            // EMPATE: O vencedor será o time com o MELHOR ranking (menor número)
            if (timeCasa.getRankingCMD() < timeVisitante.getRankingCMD()) {
                return timeCasa;
            } else {
                return timeVisitante;
            }
        }
    }

    public void imprimirResultado() {
        System.out.println("Árbitro: " +
        juiz.getNome() +
        " (Credencial: " +
        juiz.getCredencial() + ")");
        
        System.out.println(timeCasa.getNome() + " " + golCasa + " x " + golVisitante + " " + timeVisitante.getNome());

if (juiz != null) {
    System.out.println("👨‍⚖️ Árbitro: " + juiz.getNome()
            + " | Credencial: " + juiz.getCredencial());
}
        
        // Se rolou um evento especial:
        if (!this.eventoEspecial.isEmpty()) {
            System.out.println(this.eventoEspecial);
        } else {
            // Se foi um jogo normal, mostra o padrão:
            if (this.golCasa == this.golVisitante) {
                System.out.println("Resultado: Empate (Vantagem de Ranking: " + getVencedor().getNome() + ")");
            } else {
                System.out.println("Vencedor: " + getVencedor().getNome());
            }
        }
        System.out.println("-------------------------------------");
    }



}