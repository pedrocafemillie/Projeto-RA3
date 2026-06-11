package Repository;

import com.example.Models.Empresa;
import java.util.ArrayList;
import java.util.List;

public class EmpresaRepository {

    private List<Empresa> empresas = new ArrayList<>();

    public void salvar(Empresa empresa) {
        empresas.add(empresa);
    }

    public List<Empresa> listar() {
        return empresas;
    }

    public void atualizar(int indice, Empresa empresaAtualizado) {
        empresas.set(indice, empresaAtualizado);
    }

    public void remover(Empresa empresa) {
        empresas.remove(empresa);
    }
}