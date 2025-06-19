import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import java.time.Duration;
import java.util.Random;

public class ServicioAccidentes {
    private static final String[] prioridades = {"Baja", "Media", "Alta"};
    private static final Random aleatorio = new Random();

    public static void iniciar() {
        Flux.interval(Duration.ofMillis(800))
            .map(i -> prioridades[aleatorio.nextInt(prioridades.length)])
            .filter(p -> p.equals("Alta"))
            .publishOn(Schedulers.parallel())
            .subscribe(p -> {
                System.out.println("🚑 Emergencia vial: Accidente con prioridad Alta");
                ServicioMonitorEventos.registrarEvento("accidente");
            });
    }
}