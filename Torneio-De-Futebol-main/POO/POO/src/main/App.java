package main;

import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;
import model.Time;
import model.Torneio;
import view.InterfaceUsuario;

public class App {

    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        Torneio torneio = new Torneio();
        List<Time> times = inicializarTimes();

        InterfaceUsuario ui = new InterfaceUsuario(torneio, times);
        
        ui.iniciarSistema();
    }

    private static List<Time> inicializarTimes() {
        List<Time> lista = new ArrayList<>();
        lista.add(new Time("Mixto", 1));
        lista.add(new Time("Paysandu", 2));
        lista.add(new Time("Flamengo", 3));
        lista.add(new Time("Real Madrid", 4));
        lista.add(new Time("Chapada FC", 5));
        lista.add(new Time("Fenerbahce", 6));
        lista.add(new Time("Al-Nasrr", 7));
        lista.add(new Time("Inter Miami", 8));
        lista.add(new Time("Votuporanguense", 9));
        lista.add(new Time("Milan", 10));
        lista.add(new Time("Aguia de Maraba", 11));
        lista.add(new Time("Bodo/Glimt", 12));
        lista.add(new Time("Clube Brugge", 13));
        lista.add(new Time("Cuiaba", 14));
        lista.add(new Time("Barcelona", 15));
        lista.add(new Time("PSV", 16));
        lista.add(new Time("Ajax", 17));
        lista.add(new Time("Napoli", 18));
        lista.add(new Time("Juventus", 19));
        lista.add(new Time("Manchester City", 20));
        lista.add(new Time("Tottenham", 21));
        lista.add(new Time("Liverpool", 22));
        lista.add(new Time("Caceres", 23));
        lista.add(new Time("Madureira", 24));
        lista.add(new Time("Bangu", 25));
        lista.add(new Time("Volta Redonda", 26));
        lista.add(new Time("Inter de Milao", 27));
        lista.add(new Time("PSG", 28));
        lista.add(new Time("Bayern de Munique", 29));
        lista.add(new Time("Borussia Dortmund", 30));
        lista.add(new Time("Arsenal", 31));
        lista.add(new Time("Libolo", 32));
        return lista;
    }
}