public class EstacionamentoConfig {
    private static EstacionamentoConfig instancia;
    private final int CAPACIDADE_MAXIMA = 30;

    private EstacionamentoConfig() {}

    public static EstacionamentoConfig getInstancia() {
        if (instancia == null) {
            instancia = new EstacionamentoConfig();
        }
        return instancia;
    }

    public int getCapacidade() {
        return CAPACIDADE_MAXIMA;
    }
}