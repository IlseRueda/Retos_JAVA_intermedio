import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import java.time.Duration;
import java.util.Random;

public class ServicioContaminacionAire {
    private static final Random aleatorio = new Random();

    public static void iniciar() {
        Flux.interval(Duration.ofMillis(600))
            .map(i -> aleatorio.nextInt(101))
            .filter(pm -> pm > 50)
            .publishOn(Schedulers.parallel())
            .subscribe(pm -> {
                System.out.println("🌫️ Alerta: Contaminación alta (PM2.5: " + pm + " ug/m3)");
                ServicioMonitorEventos.registrarEvento("aire");
            });
    }
}