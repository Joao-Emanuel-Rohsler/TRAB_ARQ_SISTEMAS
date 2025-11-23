import java.util.List;
import java.util.stream.Collectors;

public class FiltroPorLetraStrategy implements IRelatorioStrategy {
    private String letra;

    public FiltroPorLetraStrategy(String letra) {
        this.letra = letra.toUpperCase();
    }

    @Override
    public List<Veiculo> gerarRelatorio(List<Veiculo> veiculos) {
        return veiculos.stream()
                .filter(v -> v.getPlaca().startsWith(letra))
                .collect(Collectors.toList());
    }
}