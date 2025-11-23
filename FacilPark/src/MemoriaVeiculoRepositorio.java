import java.util.ArrayList;
import java.util.List;

public class MemoriaVeiculoRepositorio implements IVeiculoRepositorio {

    private List<Veiculo> bancoDeDadosFake = new ArrayList<>();

    @Override
    public void salvar(Veiculo veiculo) {
        bancoDeDadosFake.add(veiculo);
    }

    @Override
    public Veiculo buscarPorPlaca(String placa) {
        return bancoDeDadosFake.stream()
                .filter(v -> v.getPlaca().equals(placa))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void remover(String placa) {
        bancoDeDadosFake.removeIf(v -> v.getPlaca().equals(placa));
    }

    @Override
    public List<Veiculo> listarTodos() {
        return new ArrayList<>(bancoDeDadosFake);
    }

    @Override
    public int contarVeiculos() {
        return bancoDeDadosFake.size();
    }
}