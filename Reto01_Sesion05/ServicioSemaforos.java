import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import java.time.Duration;
import java.util.Random;

public class ServicioSemaforos {
    private static final String[] estados = {"Verde", "Amarillo", "Rojo"};
    private static final Random aleatorio = new Random();
    private static int contadorRojo = 0;

    public static void iniciar() {
        Flux.interval(Duration.ofMillis(400))
            .map(i -> estados[aleatorio.nextInt(estados.length)])
            .publishOn(Schedulers.parallel())
            .subscribe(color -> {
                if (color.equals("Rojo")) {
                    contadorRojo++;
                    if (contadorRojo >= 3) {
                        System.out.println("🚦 Semáforo en Rojo detectado 3 veces seguidas en cruce Norte");
                        ServicioMonitorEventos.registrarEvento("semaforo");
                        contadorRojo = 0;
                    }
                } else {
                    contadorRojo = 0;
                }
            });
    }
}