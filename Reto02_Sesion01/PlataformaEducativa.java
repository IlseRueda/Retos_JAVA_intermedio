import java.util.*;
import java.util.function.Predicate;

public class PlataformaEducativa {
    public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
        System.out.println("📚 Materiales del curso:");
        for (MaterialCurso m : lista) {
            m.mostrarDetalle();
        }
    }

    public static void contarDuracionVideos(List<? extends Video> lista) {
        int total = 0;
        for (Video v : lista) {
            total += v.getDuracion();
        }
        System.out.println("\n🎥 Duración total de videos: " + total + " minutos");
    }

    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista) {
        for (Object obj : lista) {
            if (obj instanceof Ejercicio e) {
                e.marcarRevisado();
            }
        }
    }

    public static void filtrarPorAutor(List<? extends MaterialCurso> lista, Predicate<MaterialCurso> filtro) {
        System.out.println("\n🔍 Filtrando materiales por autor:");
        for (MaterialCurso m : lista) {
            if (filtro.test(m)) {
                m.mostrarDetalle();
            }
        }
    }
}