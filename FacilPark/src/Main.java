import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("BACKEND TEST");

        IVeiculoRepositorio repositorio = new MemoriaVeiculoRepositorio();
        EstacionamentoService service = new EstacionamentoService(repositorio);

        // Observer
        service.adicionarObserver(qtd -> System.out.println("!!! ALERTA: Lotação máxima atingida (" + qtd + ") !!!"));

        try {
            // TESTE 1: Entradas
            service.registrarEntrada("ABC1234");
            service.registrarEntrada("XYZ9876");
            service.registrarEntrada("HJJ5555");
            System.out.println("Ocupação: " + service.getStatusOcupacao());

            // TESTE 2: Duplicidade
            try {
                service.registrarEntrada("ABC1234");
            } catch (Exception e) {
                System.out.println("Erro esperado capturado: " + e.getMessage());
            }

            // TESTE 3: Relatório Geral
            System.out.println("\n--- Relatório Geral ---");
            List<Veiculo> relatorio = service.gerarRelatorio(new OrdenacaoPorEntradaStrategy());
            for (Veiculo v : relatorio) {
                System.out.println(v);
            }

            // TESTE 4: Filtro
            System.out.println("\n--- Filtro Placas 'H' ---");
            List<Veiculo> filtroH = service.gerarRelatorio(new FiltroPorLetraStrategy("H"));
            for (Veiculo v : filtroH) {
                System.out.println(v);
            }

            // TESTE 5: Saída
            service.registrarSaida("ABC1234");
            System.out.println("\nSaída realizada. Ocupação: " + service.getStatusOcupacao());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
