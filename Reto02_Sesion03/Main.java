import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Sucursal> sucursales = Arrays.asList(
            new Sucursal("Centro", Arrays.asList(
                new Encuesta("Ana", "El tiempo de espera fue largo", 2),
                new Encuesta("Luis", null, 4)
            )),
            new Sucursal("Norte", Arrays.asList(
                new Encuesta("Marta", "La atención fue buena, pero la limpieza puede mejorar", 3),
                new Encuesta("Carlos", null, 5)
            ))
        );

        System.out.println("📊 Generando mensajes de seguimiento para el área de calidad...");

        sucursales.stream()
            .flatMap(sucursal ->
                sucursal.getEncuestas().stream()
                    .filter(e -> e.getCalificacion() <= 3)
                    .flatMap(e -> e.getComentario()
                        .map(comentario ->
                            Stream.of("Sucursal " + sucursal.getNombre() +
                                      ": Seguimiento a paciente con comentario: \"" + comentario + "\""))
                        .orElseGet(Stream::empty)
                    )
            )
            .forEach(System.out::println);
    }
}