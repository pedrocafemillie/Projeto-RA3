package Repository;

import com.example.Models.Cartao;
import java.util.ArrayList;
import java.util.List;

public class CartaoRepository {

    private List<Cartao> cartaos = new ArrayList<>();

    public void salvar(Cartao cartao) {
        cartaos.add(cartao);
    }

    public List<Cartao> listar() {
        return cartaos;
    }

    public void atualizar(int indice, Cartao cartaoAtualizado) {
        cartaos.set(indice, cartaoAtualizado);
    }

    public void remover(Cartao cartao) {
        cartaos.remove(cartao);
    }
}