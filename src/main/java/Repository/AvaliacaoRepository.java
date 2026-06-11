package Repository;

import com.example.Models.Avaliacao;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoRepository {

    private List<Avaliacao> avaliacaos = new ArrayList<>();

    public void salvar(Avaliacao avaliacao) {
        avaliacaos.add(avaliacao);
    }

    public List<Avaliacao> listar() {
        return avaliacaos;
    }

    public void atualizar(int indice, Avaliacao avaliacaoAtualizado) {
        avaliacaos.set(indice, avaliacaoAtualizado);
    }

    public void remover(Avaliacao avaliacao) {
        avaliacaos.remove(avaliacao);
    }
}