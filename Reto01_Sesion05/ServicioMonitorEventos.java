import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ServicioMonitorEventos {
    private static final ConcurrentLinkedQueue<String> eventos = new ConcurrentLinkedQueue<>();

    public static void registrarEvento(String tipo) {
        eventos.add(tipo);
    }

    public static void monitorear() {
        Flux.interval(Duration.ofSeconds(1))
            .subscribe(tick -> {
                if (eventos.size() >= 3) {
                    System.out.println("🚨 Alerta global: Múltiples eventos críticos detectados en Meridian Prime");
                }
                eventos.clear();
            });
    }
}