package Repository;

import com.example.Models.Servico;
import java.util.ArrayList;
import java.util.List;

public class ServicoRepository {

    private List<Servico> servicos = new ArrayList<>();

    public void salvar(Servico servico) {
        servicos.add(servico);
    }

    public List<Servico> listar() {
        return servicos;
    }

    public void atualizar(int indice, Servico servicoAtualizado) {
        servicos.set(indice, servicoAtualizado);
    }

    public void remover(Servico servico) {
        servicos.remove(servico);
    }
}