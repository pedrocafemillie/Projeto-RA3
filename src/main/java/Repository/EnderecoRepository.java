package Repository;

import com.example.Models.Endereco;
import java.util.ArrayList;
import java.util.List;

public class EnderecoRepository {

    private List<Endereco> enderecos = new ArrayList<>();

    public void salvar(Endereco endereco) {
        enderecos.add(endereco);
    }

    public List<Endereco> listar() {
        return enderecos;
    }

    public void atualizar(int indice, Endereco enderecoAtualizado) {
        enderecos.set(indice, enderecoAtualizado);
    }

    public void remover(Endereco endereco) {
        enderecos.remove(endereco);
    }
}