import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class MovilidadApp {

    public CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("🚦 Calculando ruta...");
                Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 3000));
                return "Norte -> Sur";
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al calcular la ruta");
            }
        });
    }

    public CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("💰 Estimando tarifa...");
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
                return 150.00;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al estimar la tarifa");
            }
        });
    }

    public void procesarSolicitud() {
        calcularRuta().thenCombine(estimarTarifa(), (ruta, tarifa) -> {
            return "✅ 🚗 Ruta calculada: " + ruta + " | Tarifa estimada: $" + tarifa;
        }).exceptionally(ex -> {
            return "⚠️ Hubo un error al procesar la solicitud: " + ex.getMessage();
        }).thenAccept(System.out::println);
    }

    public static void main(String[] args) {
        MovilidadApp app = new MovilidadApp();
        app.procesarSolicitud();

        // Para evitar que el programa se cierre antes de que terminen los procesos asincrónicos
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}