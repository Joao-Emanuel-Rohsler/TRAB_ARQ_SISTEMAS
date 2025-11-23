import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrdenacaoPorEntradaStrategy implements IRelatorioStrategy {
    @Override
    public List<Veiculo> gerarRelatorio(List<Veiculo> veiculos) {
        return veiculos.stream()
                .sorted(Comparator.comparing(Veiculo::getHoraEntrada))
                .collect(Collectors.toList());
    }
}