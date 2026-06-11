package Repository;

import com.example.Models.Prestador;
import java.util.ArrayList;
import java.util.List;

public class PrestadorRepository {

    private List<Prestador> prestadors = new ArrayList<>();

    public void salvar(Prestador prestador) {
        prestadors.add(prestador);
    }

    public List<Prestador> listar() {
        return prestadors;
    }

    public void atualizar(int indice, Prestador clienteAtualizado) {
        prestadors.set(indice, clienteAtualizado);
    }

    public void remover(Prestador cliente) {
        prestadors.remove(cliente);
    }
}