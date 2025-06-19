import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import java.time.Duration;
import java.util.Random;

public class ServicioTrenes {
    private static final Random aleatorio = new Random();

    public static void iniciar() {
        Flux.interval(Duration.ofMillis(700))
            .map(i -> aleatorio.nextInt(11))
            .delayElements(Duration.ofMillis(100))
            .filter(min -> min > 5)
            .publishOn(Schedulers.parallel())
            .subscribe(min -> {
                System.out.println("🚝 Tren con retraso crítico: " + min + " minutos");
                ServicioMonitorEventos.registrarEvento("tren");
            });
    }
}