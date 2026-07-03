package main;

import java.util.List;
import javax.swing.UIManager;
import model.Time;
import model.Torneio;
import persistencia.IDAOTimes;
import persistencia.ImplTime;
import view.InterfaceUsuario;

public class App {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        Torneio torneio = new Torneio();

        // Busca os times no banco de dados
        IDAOTimes dao = new ImplTime();
        List<Time> times = dao.listarTodos();

        InterfaceUsuario ui = new InterfaceUsuario(torneio, times);

        ui.iniciarSistema();
    }

}