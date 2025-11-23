import java.util.ArrayList;
import java.util.List;

public class EstacionamentoService {

    private final IVeiculoRepositorio repositorio;
    private final List<IEstacionamentoObserver> observadores = new ArrayList<>();

    public EstacionamentoService(IVeiculoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void adicionarObserver(IEstacionamentoObserver observer) {
        this.observadores.add(observer);
    }

    public void registrarEntrada(String placa) throws Exception {
        int vagasOcupadas = repositorio.contarVeiculos();
        int capacidade = EstacionamentoConfig.getInstancia().getCapacidade();

        if (vagasOcupadas >= capacidade) {
            observadores.forEach(o -> o.notificarLotacao(vagasOcupadas));
            throw new Exception("O estacionamento está LOTADO.");
        }

        if (repositorio.buscarPorPlaca(placa) != null) {
            throw new Exception("Veículo com placa " + placa + " já está estacionado.");
        }

        Veiculo novoVeiculo = VeiculoFactory.criar(placa);
        repositorio.salvar(novoVeiculo);
        System.out.println("[LOG] Entrada registrada: " + placa);
    }

    public void registrarSaida(String placa) throws Exception {
        Veiculo v = repositorio.buscarPorPlaca(placa);
        if (v == null) {
            throw new Exception("Veículo não encontrado.");
        }
        repositorio.remover(placa);
        System.out.println("[LOG] Saída registrada: " + placa);
    }

    public List<Veiculo> gerarRelatorio(IRelatorioStrategy estrategia) {
        List<Veiculo> todos = repositorio.listarTodos();
        return estrategia.gerarRelatorio(todos);
    }

    public String getStatusOcupacao() {
        return repositorio.contarVeiculos() + "/" + EstacionamentoConfig.getInstancia().getCapacidade();
    }
}
