import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import java.time.Duration;
import java.util.Random;

public class ServicioSensoresTrafico {
    private static final Random aleatorio = new Random();

    public static void iniciar() {
        Flux.interval(Duration.ofMillis(500))
            .map(tick -> aleatorio.nextInt(101))
            .onBackpressureBuffer()
            .filter(congestion -> congestion > 70)
            .publishOn(Schedulers.parallel())
            .subscribe(c -> {
                System.out.println("🚗 Alerta: Congestión del " + c + "% en Avenida Solar");
                ServicioMonitorEventos.registrarEvento("trafico");
            });
    }
}