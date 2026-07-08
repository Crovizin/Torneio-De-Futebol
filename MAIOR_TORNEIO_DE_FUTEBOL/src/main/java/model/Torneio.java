package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Torneio {
    private List<Time> todosTimes;
    private List<Grupo> grupos;
    private List<Juiz> juizes = new ArrayList<>();

    public Torneio() {
        this.todosTimes = new ArrayList<>();
        this.grupos = new ArrayList<>();

        // Inicializa os 8 grupos automaticamente na criação do torneio
        String[] letrasDosGrupos = {"A", "B", "C", "D", "E", "F", "G", "H"};
        for (String letra : letrasDosGrupos) {
            this.grupos.add(new Grupo("Grupo " + letra));
        }
    }

    
    public void adicionarTime(Time time) {
        this.todosTimes.add(time);
    }

    public void adicionarJuiz(Juiz juiz) {
    juizes.add(juiz);
    }

    public List<Juiz> getJuizes() {
    return juizes;
    }

    
    public void sortearGrupos() {
        // 1. Ordena a lista de times pelo RankingCMD. 
        // Como não tem ".reversed()", ele vai do 1 (melhor) ao 32 (pior).
        todosTimes.sort(Comparator.comparingInt(Time::getRankingCMD));

        // 2. Separa os 8 primeiros (Cabeças de Chave) e os 24 restantes
        List<Time> cabecasDeChave = new ArrayList<>(todosTimes.subList(0, 8));
        List<Time> restantes = new ArrayList<>(todosTimes.subList(8, todosTimes.size()));

        // 3. Embaralha apenas os 24 times restantes para o sorteio ser justo e aleatório
        Collections.shuffle(restantes);

        // 4. Distribui os times pelos 8 grupos
        for (int i = 0; i < 8; i++) {
            Grupo grupoAtual = grupos.get(i);
            
            // Coloca 1 cabeça de chave neste grupo (Ex: Grupo A recebe o 1º, Grupo B recebe o 2º...)
            grupoAtual.adicionarTime(cabecasDeChave.get(i));
            
            // Retira 3 times aleatórios da lista de restantes e coloca no grupo
            grupoAtual.adicionarTime(restantes.remove(0));
            grupoAtual.adicionarTime(restantes.remove(0));
            grupoAtual.adicionarTime(restantes.remove(0));
        }
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }
}
