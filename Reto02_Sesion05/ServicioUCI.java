import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.Random;
import java.util.Comparator;

public class ServicioUCI {

    private static final Random rnd = new Random();

    public static Flux<EventoCritico> generarFlujoPaciente(int id) {
        return Flux.interval(Duration.ofMillis(300))
            .map(i -> new Paciente(
                id,
                40 + rnd.nextInt(100),  // FC: 40–140
                80 + rnd.nextInt(80),   // PS: 80–160
                50 + rnd.nextInt(40),   // PD: 50–90
                85 + rnd.nextInt(16)))  // SpO2: 85–100
            .flatMap(paciente -> Flux.fromIterable(filtrarEventosCriticos(paciente)))
            .delayElements(Duration.ofSeconds(1)); // backpressure
    }

    public static Flux<EventoCritico> flujoTotal() {
        return Flux.merge(
            generarFlujoPaciente(1),
            generarFlujoPaciente(2),
            generarFlujoPaciente(3)
        )
        .sort(Comparator.comparingInt(e -> PrioridadVital.getOrden(e.tipo)));
    }

    private static java.util.List<EventoCritico> filtrarEventosCriticos(Paciente p) {
        var eventos = new java.util.ArrayList<EventoCritico>();

        if (p.frecuenciaCardiaca < 50 || p.frecuenciaCardiaca > 120)
            eventos.add(new EventoCritico(p.id, PrioridadVital.FC, "FC crítica: " + p.frecuenciaCardiaca + " bpm"));
        if (p.presionSistolica > 140 || p.presionDiastolica > 90
         || p.presionSistolica < 90 || p.presionDiastolica < 60)
            eventos.add(new EventoCritico(p.id, PrioridadVital.PA, "PA crítica: " + p.presionSistolica + "/" + p.presionDiastolica + " mmHg"));
        if (p.oxigeno < 90)
            eventos.add(new EventoCritico(p.id, PrioridadVital.SPO2, "SpO2 baja: " + p.oxigeno + "%"));

        return eventos;
    }
}