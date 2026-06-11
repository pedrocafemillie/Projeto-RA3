package Repository;

import com.example.Models.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    private List<Cliente> clientes = new ArrayList<>();

    public void salvar(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> listar() {
        return clientes;
    }

    public void atualizar(int indice, Cliente clienteAtualizado) {
        clientes.set(indice, clienteAtualizado);
    }

    public void remover(Cliente cliente) {
        clientes.remove(cliente);
    }
}