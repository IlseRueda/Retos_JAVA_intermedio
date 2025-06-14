import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<MaterialCurso> materiales = new ArrayList<>();
        materiales.add(new Video("Introducción a Java", "Gerardo", 20));
        materiales.add(new Video("Java básico", "Irais", 10));
        materiales.add(new Articulo("Herencia", "Lourdes", 10000));
        materiales.add(new Articulo("Conceptos basicos java", "Adela", 25500));
        materiales.add(new Ejercicio(" Compilación y ejecución de código en Java", "Guadalupe"));
        materiales.add(new Ejercicio("POO en Java", "Gerardo"));

        PlataformaEducativa.mostrarMateriales(materiales);

        // Filtrar videos para contar duración
        List<Video> videos = materiales.stream()
            .filter(m -> m instanceof Video)
            .map(m -> (Video) m)
            .toList();
        PlataformaEducativa.contarDuracionVideos(videos);
        PlataformaEducativa.marcarEjerciciosRevisados(materiales);
        PlataformaEducativa.filtrarPorAutor(materiales, m -> m.getAutor().equalsIgnoreCase("Mario"));
    }
}