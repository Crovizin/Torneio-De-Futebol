package view;

import exception.JuizDuplicadoException;
import exception.TimeNaoEncontradoException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import model.Grupo;
import model.Juiz;
import model.Matamata;
import model.Time;
import model.Torneio;
import persistencia.IDAOTimes;
import persistencia.ImplTime;

public class InterfaceUsuario {

    private Torneio torneio;
    private List<Time> listaDeTimes;
    private IDAOTimes dao = new ImplTime();

    private boolean gruposSorteados = false;
    private boolean[] grupoJogado = new boolean[8];
    private int gruposJogadosCount = 0;
    private int etapaMataMata = 0; 
    
    private List<Time> classificadosParaOitavas = new ArrayList<>();
    private List<Time> classificadosParaQuartas = new ArrayList<>();
    private List<Time> classificadosParaSemis = new ArrayList<>();
    private List<Time> finalistas = new ArrayList<>();
    private List<Time> campeao = new ArrayList<>();

    private ByteArrayOutputStream terminalOculto = new ByteArrayOutputStream();
    
    private void pesquisarTime() {

    String nome = JOptionPane.showInputDialog(
            null,
            "Digite o nome do time:",
            "Pesquisar Time",
            JOptionPane.QUESTION_MESSAGE);

    if (nome == null || nome.isBlank()) {
        return;
    }

    try {

        Time time = dao.buscarPorNome(nome);

        String mensagem =
                "Nome: " + time.getNome() +
                "\nPaís: " + time.getPais() +
                "\nRanking: " + time.getRankingCMD() +
                "\nChance de título: " + time.getChanceTitulo() + "%" +
                "\n\nCuriosidade:\n" + time.getCuriosidade() +
                "\n\nResumo:\n" + time.getResumo();

        JOptionPane.showMessageDialog(
                null,
                mensagem,
                "Informações do Time",
                JOptionPane.INFORMATION_MESSAGE);

    } catch (TimeNaoEncontradoException e) {

        JOptionPane.showMessageDialog(
                null,
                e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);}}

    

    private ImageIcon iconePrincipal = carregarIcone("/img/trofeu.png", 64, 64);

    public InterfaceUsuario(Torneio torneio, List<Time> listaDeTimes) {
        this.torneio = torneio;
        this.listaDeTimes = listaDeTimes;
        
        
        System.setOut(new PrintStream(terminalOculto, true, StandardCharsets.UTF_8));
    }

    public void iniciarSistema() {
        JOptionPane.showMessageDialog(null, 
            "BEM-VINDO AO MAIOR TORNEIO DE FUTEBOL DO MUNDO!", 
            "🏆 TORNEIO MUNDIAL DE FUTEBOL", 
            JOptionPane.INFORMATION_MESSAGE, 
            iconePrincipal);
            cadastrarJuizes();
        boolean rodando = true;
        
        while (rodando) {
String[] opcoesMenu = {
    "1. Clubes",
    "2. Pesquisar Time",
    "3. Sortear",
    "4. Grupos",
    "5. Mata-Mata",
    "6. Sair"
};

            int escolha = JOptionPane.showOptionDialog(null, 
                    "Escolha uma etapa do torneio:", 
                    "☰ Menu Principal",
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.PLAIN_MESSAGE, 
                    iconePrincipal, 
                    opcoesMenu, opcoesMenu[0]);

            switch (escolha) {
                case 0: mostrarClubes(); break;
                case 1: 
                 pesquisarTime(); break;
                case 2:
                    sortearGrupos(); break;
                case 3:
                  if (!gruposSorteados) mostrarAviso(" Você precisa Sortear os Grupos primeiro!");
                    else menuFaseDeGrupos();
                    break;

                case 4:
                    if (gruposJogadosCount < 8) mostrarAviso(" Jogue todos os 8 grupos primeiro!");
                    else menuMataMata();
                    break;

                    case 5:
                    case JOptionPane.CLOSED_OPTION:
                     rodando = false;
                     break;
            }}
        JOptionPane.showMessageDialog(null, "Sistema encerrado. Obrigado por acompanhar!");}
    

    private void mostrarClubes() {
        terminalOculto.reset(); 
        System.out.println("Todos os maiores times do mundo: ");
        for (Time t : listaDeTimes) {
            System.out.println("Ranking: " + String.format("%02d", t.getRankingCMD()) + " | Time: " + t.getNome());
        }
        mostrarPopUp("📋 Clubes Participantes");
    }

    private void cadastrarJuizes() {

    int quantidade = 0;

    while (quantidade < 3) {

        try {
            String entrada = JOptionPane.showInputDialog(
                    null,
                    "Quantos juízes deseja cadastrar?\n(Mínimo 3)");
            if (entrada == null)
                System.exit(0);
            quantidade = Integer.parseInt(entrada);
            if (quantidade < 3) {
                JOptionPane.showMessageDialog(
                        null,
                        "É necessário cadastrar pelo menos 3 juízes.");
            }
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Digite apenas números.");
        }
    }
    for (int i = 1; i <= quantidade; i++) {
        String nome;
        int credencial;

while (true) {

    nome = JOptionPane.showInputDialog(
            "Nome do juiz " + i + ":");

    if (nome == null)
        System.exit(0);

    if (!nome.isBlank() &&
        nome.matches("[A-Za-zÀ-ÿ ]+")) {
        break;
    }

    JOptionPane.showMessageDialog(
            null,
            "Digite apenas letras e não deixe o nome vazio.");
}
while (true) {

    try {

        credencial = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Credencial do juiz " + i + ":"));

        if (credencial > 0) {
            break;
        }

        JOptionPane.showMessageDialog(
                null,
                "A credencial deve ser um número maior que zero.");

    } catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(
                null,
                "A credencial deve conter apenas números.");
    }
}

try {

    validarJuiz(nome, credencial);

    torneio.adicionarJuiz(new Juiz(nome, credencial));

} catch (JuizDuplicadoException e) {

    JOptionPane.showMessageDialog(
            null,
            e.getMessage(),
            "Erro",
            JOptionPane.ERROR_MESSAGE);

    i--;
}
    }
    JOptionPane.showMessageDialog(
            null,
            quantidade + " juízes cadastrados com sucesso!");
}
    private void sortearGrupos() {
        if (gruposSorteados) {
            JOptionPane.showMessageDialog(null, "✅ Os grupos já foram sorteados!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        terminalOculto.reset();
        for (Time t : listaDeTimes) torneio.adicionarTime(t);
        torneio.sortearGrupos();
        gruposSorteados = true;
        
        for (Grupo grupo : torneio.getGrupos()) {
            System.out.println("✅ " + grupo.getNome() + " montado com sucesso.");
            
            grupo.mostrarGrupos();
        }
        System.out.println("\nPRONTO PARA COMEÇAR A FASE DE GRUPOS! ");
        mostrarPopUp("⚽ Sorteio dos Grupos");
    }

    private void menuFaseDeGrupos() {
        boolean noSubmenu = true;
        String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H"};

        while (noSubmenu) {
            String[] opcoesGrupos = new String[9];
            for (int i = 0; i < 8; i++) {
                opcoesGrupos[i] = "Grupo " + letras[i] + (grupoJogado[i] ? " (Finalizado)" : "");
            }
            opcoesGrupos[8] = "Voltar";

            int escolha = JOptionPane.showOptionDialog(null, 
                    "Selecione um grupo para simular:", 
                    "👥Fase de Grupos",
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.PLAIN_MESSAGE, 
                    null, opcoesGrupos, opcoesGrupos[0]);

            if (escolha == 8 || escolha == JOptionPane.CLOSED_OPTION) {
                noSubmenu = false; 
            } else if (escolha >= 0 && escolha <= 7) {
                if (grupoJogado[escolha]) mostrarAviso("Este grupo já jogou suas partidas!");
                else simularGrupoEspecifico(escolha);
            }
        }
    }

    private void simularGrupoEspecifico(int index) {
        terminalOculto.reset();
        Grupo g = torneio.getGrupos().get(index);
        
        g.gerarJogosDoGrupo();
        g.jogarFase(torneio.getJuizes());
        
        // Organiza a tabela PRIMEIRO, depois mostra!
        List<Time> classificadosDoGrupo = g.obterClassificados();
        classificadosParaOitavas.addAll(classificadosDoGrupo);
        
        g.mostrarTabela();
        
        System.out.println("\n⭐ Classificados: " + classificadosDoGrupo.get(0).getNome() + " e " + classificadosDoGrupo.get(1).getNome());

        grupoJogado[index] = true;
        gruposJogadosCount++;
        mostrarPopUp("📊 Resultados do " + g.getNome());
    }


    private void menuMataMata() {
        boolean noSubmenu = true;

        while (noSubmenu) {
            String[] opcoesMataMata = {
                etapaMataMata > 0 ? "Oitavas (Concluído)" : "1. Oitavas",
                etapaMataMata > 1 ? "Quartas (Concluído)" : "2. Quartas",
                etapaMataMata > 2 ? "Semis (Concluído)" : "3. Semifinal",
                etapaMataMata > 3 ? "Final (Concluído)" : "4. Final",
                etapaMataMata == 4 ? "5. 🏆 Revelar Campeão!" : "5. Campeão (Bloqueado)",
                "Voltar"
            };

            int escolha = JOptionPane.showOptionDialog(null, 
                    "Fases Eliminatórias:", "🏟️Mata-Mata",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, 
                    null, opcoesMataMata, opcoesMataMata[0]);

            switch (escolha) {
                case 0: simularFaseMataMata("Oitavas de Final", 0); break;
                case 1: simularFaseMataMata("Quartas de Final", 1); break;
                case 2: simularFaseMataMata("Semifinal", 2); break;
                case 3: simularFaseMataMata("Final", 3); break;
                case 4: 
                    if (etapaMataMata == 4) revelarCampeao(); 
                    else mostrarAviso("Jogue a final primeiro!");
                    break;
                case 5:
                case JOptionPane.CLOSED_OPTION:
                    noSubmenu = false;
                    break;
            }
        }
    }

    private void simularFaseMataMata(String nomeDaFase, int etapaNecessaria) {
        if (etapaMataMata < etapaNecessaria) {
            mostrarAviso(" Jogue a fase anterior primeiro!"); return;
        }
        if (etapaMataMata > etapaNecessaria) {
            JOptionPane.showMessageDialog(null, " Fase já jogada!", "Aviso", JOptionPane.INFORMATION_MESSAGE); return;
        }

        terminalOculto.reset();
        Matamata fase;
        List<Time> timesQuePassaram = new ArrayList<>();

        if (etapaNecessaria == 0) {
            fase = new Matamata(nomeDaFase, classificadosParaOitavas);
            fase.jogarFase(torneio.getJuizes());
            classificadosParaQuartas = fase.obterClassificados();
            timesQuePassaram = classificadosParaQuartas;
        } else if (etapaNecessaria == 1) {
            fase = new Matamata(nomeDaFase, classificadosParaQuartas);
            fase.jogarFase(torneio.getJuizes());
            classificadosParaSemis = fase.obterClassificados();
            timesQuePassaram = classificadosParaSemis;
        } else if (etapaNecessaria == 2) {
            fase = new Matamata(nomeDaFase, classificadosParaSemis);
            fase.jogarFase(torneio.getJuizes());
            finalistas = fase.obterClassificados();
            timesQuePassaram = finalistas;
        } else {
            fase = new Matamata(nomeDaFase, finalistas);
            fase.jogarFase(torneio.getJuizes());
            campeao = fase.obterClassificados();
            timesQuePassaram = campeao;
        }

        System.out.println("\n⭐ --- AVANÇAM DE FASE --- ⭐");
        for (Time t : timesQuePassaram) {
            System.out.println("-> " + t.getNome());
        }

        etapaMataMata++;
        mostrarPopUp("🔥 " + nomeDaFase);
    }

    private void validarJuiz(String nome, int credencial)
        throws JuizDuplicadoException {

    for (Juiz juiz : torneio.getJuizes()) {

        if (juiz.getNome().equalsIgnoreCase(nome)) {
            throw new JuizDuplicadoException(
                    "Já existe um juiz com o nome \"" + nome + "\".");
        }

        if (juiz.getCredencial() == credencial) {
            throw new JuizDuplicadoException(
                    "A credencial " + credencial + " já está cadastrada.");
        }
    }
}

    private void revelarCampeao() {
        terminalOculto.reset();
        System.out.println("\n\n\n                    🌟 PARABÉNS! 🌟\n");
        System.out.println("              O GRANDE CAMPEÃO DO TORNEIO É:\n");
        System.out.println("                     " + campeao.get(0).getNome().toUpperCase() + "!!!");
        System.out.println("\n\n\n");
        
        mostrarPopUp("🏆 TEMOS UM CAMPEÃO! 🏆");
        System.exit(0); 
    }

    // ==========================================
    // FERRAMENTAS VISUAIS
    // ==========================================
    private void mostrarPopUp(String titulo) {
        
        String texto = terminalOculto.toString(StandardCharsets.UTF_8);

        JTextArea textArea = new JTextArea(texto);
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textArea.setBackground(new Color(30, 30, 30)); // Fundo cinza bem escuro
        textArea.setForeground(new Color(255, 215, 0)); // Letras em dourado (ou Color.WHITE)
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 400)); 
        
        JOptionPane.showMessageDialog(null, scrollPane, titulo, JOptionPane.PLAIN_MESSAGE, iconePrincipal);
    }

    private void mostrarAviso(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Bloqueado", JOptionPane.WARNING_MESSAGE);
    }
    
    private ImageIcon carregarIcone(String caminhoDentroDoProjeto, int l, int a) {
        try {
            java.net.URL imgURL = getClass().getResource(caminhoDentroDoProjeto);
            if(imgURL != null) {
                Image img = new ImageIcon(imgURL).getImage().getScaledInstance(l, a, Image.SCALE_SMOOTH);
                return new ImageIcon(img);
            }
        } catch (Exception e) {}
        return null;
    }
}


