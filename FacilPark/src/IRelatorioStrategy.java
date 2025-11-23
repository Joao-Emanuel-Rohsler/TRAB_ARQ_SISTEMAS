import java.util.List;

public interface IRelatorioStrategy {
    List<Veiculo> gerarRelatorio(List<Veiculo> veiculos);
}