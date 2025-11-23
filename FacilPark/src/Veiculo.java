import java.time.LocalDateTime;

public class Veiculo {
    private String placa;
    private LocalDateTime horaEntrada;

    protected Veiculo(String placa) {
        this.placa = placa;
        this.horaEntrada = LocalDateTime.now();
    }

    public String getPlaca() {
        return placa;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    @Override
    public String toString() {
        return "Veiculo [Placa=" + placa + ", Entrada=" + horaEntrada + "]";
    }
}