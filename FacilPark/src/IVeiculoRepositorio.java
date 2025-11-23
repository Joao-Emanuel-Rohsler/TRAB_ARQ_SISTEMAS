import java.util.List;

public interface IVeiculoRepositorio {
    void salvar(Veiculo veiculo);
    Veiculo buscarPorPlaca(String placa);
    void remover(String placa);
    List<Veiculo> listarTodos();
    int contarVeiculos();
}