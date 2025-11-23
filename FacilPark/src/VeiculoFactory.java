public class VeiculoFactory {

    public static Veiculo criar(String placa) {
        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException("A placa não pode ser vazia.");
        }
        if (placa.length() > 7) {
            throw new IllegalArgumentException("A placa deve ter no máximo 7 caracteres.");
        }
        return new Veiculo(placa.toUpperCase());
    }
}