package main;

import java.util.ArrayList;
import java.util.List;
import model.Grupo;
import model.Matamata;
import model.Time;
import model.Torneio;

public class App {
    public static void main(String[] args) {
        System.out.println("🏆 === BEM-VINDO AO MAIOR TORNEIO DE FUTEBOL === 🏆\n");

        List<Time> listaDeTimes = new ArrayList<>();
        
        // Os 32 maiores times do muundo
        listaDeTimes.add(new Time("Mixto", 1));
        listaDeTimes.add(new Time("Paysandu", 2));
        listaDeTimes.add(new Time("Flamengo", 3));
        listaDeTimes.add(new Time("Real Madrid", 4));
        listaDeTimes.add(new Time("Chapada FC", 5));
        listaDeTimes.add(new Time("Fenerbahce", 6));
        listaDeTimes.add(new Time("Al-Nasrr", 7));
        listaDeTimes.add(new Time("Inter Miami", 8));
        listaDeTimes.add(new Time("Votuporanguense", 9));
        listaDeTimes.add(new Time("Milan", 10));
        listaDeTimes.add(new Time("Aguia de Maraba", 11));
        listaDeTimes.add(new Time("Bodo/Glimt", 12));
        listaDeTimes.add(new Time("Clube Brugge", 13));
        listaDeTimes.add(new Time("Cuiaba", 14));
        listaDeTimes.add(new Time("Barcelona", 15));
        listaDeTimes.add(new Time("PSV", 16));
        listaDeTimes.add(new Time("Ajax", 17));
        listaDeTimes.add(new Time("Napoli", 18));
        listaDeTimes.add(new Time("Juventus", 19));
        listaDeTimes.add(new Time("Manchester City", 20));
        listaDeTimes.add(new Time("Tottenham", 21));
        listaDeTimes.add(new Time("Liverpool", 22));
        listaDeTimes.add(new Time("Caceres", 23));
        listaDeTimes.add(new Time("Madureira", 24));
        listaDeTimes.add(new Time("Bangu", 25));
        listaDeTimes.add(new Time("Volta Redonda", 26));
        listaDeTimes.add(new Time("Inter de Milao", 27));
        listaDeTimes.add(new Time("PSG", 28));
        listaDeTimes.add(new Time("Bayern de Munique", 29));
        listaDeTimes.add(new Time("Borussia Dortmund", 30));
        listaDeTimes.add(new Time("Arsenal", 31));
        listaDeTimes.add(new Time("Libolo", 32));

        // 1. Mostrar todos os times no início
        System.out.println("=== LISTA DE TIMES PARTICIPANTES ===");
        System.out.println("Total de times criados: " + listaDeTimes.size());
        
        for (Time t : listaDeTimes) {
            System.out.println("Ranking: " + t.getRankingCMD() + " | Time: " + t.getNome());
        }
        System.out.println("=======================================\n");

       
        // PREPARAÇÃO DO TORNEIO
 
        Torneio torneio = new Torneio();

        // Passando os times da lista para dentro do gerenciador do torneio
        for (Time t : listaDeTimes) {
            torneio.adicionarTime(t);
        }

        // Sorteio dos grupos (Garante os cabeças de chave e espalha o resto)
        System.out.println("Sorteando os grupos...");
        torneio.sortearGrupos();

        // FASE DE GRUPOS
        System.out.println("\n--- INICIANDO FASE DE GRUPOS ---");
        List<Time> classificadosParaOitavas = new ArrayList<>();

        // Percorre os 8 grupos gerados no torneio
        for (Grupo grupo : torneio.getGrupos()) { 
            grupo.gerarJogosDoGrupo(); 
            grupo.jogarFase();         
            
            // Chama os classificados 
            List<Time> classificadosDoGrupo = grupo.obterClassificados();
            classificadosParaOitavas.addAll(classificadosDoGrupo);
            
            // Imprime a tabela do grupo
            grupo.mostrarTabela();
            
            // Imprime os classificados no formato que você pediu
            System.out.println("\nClassificados - " + classificadosDoGrupo.get(0).getNome() + ", " + classificadosDoGrupo.get(1).getNome() + "\n");
        }

        // MATA-MATA
       
        // Oitavas de Final
        System.out.println("\n--- OITAVAS DE FINAL ---");
        Matamata oitavas = new Matamata("Oitavas de Final", classificadosParaOitavas);
        oitavas.jogarFase();
        List<Time> classificadosParaQuartas = oitavas.obterClassificados(); 

        // Quartas de Final
        System.out.println("\n--- QUARTAS DE FINAL ---");
        Matamata quartas = new Matamata("Quartas de Final", classificadosParaQuartas);
        quartas.jogarFase();
        List<Time> classificadosParaSemis = quartas.obterClassificados();

        // Semifinal
        System.out.println("\n--- SEMIFINAL ---");
        Matamata semis = new Matamata("Semifinal", classificadosParaSemis);
        semis.jogarFase();
        List<Time> finalistas = semis.obterClassificados();

        // Grande Final
        System.out.println("\n--- GRANDE FINAL --- ");
        Matamata finalDoTorneio = new Matamata("Final", finalistas);
        finalDoTorneio.jogarFase();
        List<Time> campeao = finalDoTorneio.obterClassificados();

        // CAMPEÃO
        System.out.println("\nO GRANDE CAMPEÃO DO TORNEIO É: " + campeao.get(0).getNome().toUpperCase() + "!!!");
    }
}