package Repository;

import com.example.Models.Trabalho;
import java.util.ArrayList;
import java.util.List;

public class TrabalhoRepository {

    private List<Trabalho> trabalhos = new ArrayList<>();

    public void salvar(Trabalho trabalho) {
        trabalhos.add(trabalho);
    }

    public List<Trabalho> listar() {
        return trabalhos;
    }

    public void atualizar(int indice, Trabalho trabalhoAtualizado) {
        trabalhos.set(indice, trabalhoAtualizado);
    }

    public void remover(Trabalho trabalho) {
        trabalhos.remove(trabalho);
    }
}