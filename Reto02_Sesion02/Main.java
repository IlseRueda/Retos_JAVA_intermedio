import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("🏥 Iniciando acceso a la Sala de cirugía...");

        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");

        Runnable draRueda = () -> salaCirugia.usar("Dra. Rueda");
        Runnable drBautista = () -> salaCirugia.usar("Dr. Bautista");
        Runnable enfermeraHernandez = () -> salaCirugia.usar("Enfermera Hernández");
        Runnable drGarcia = () -> salaCirugia.usar("Dr. García");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.execute(draRueda);
        executor.execute(drBautista);
        executor.execute(enfermeraHernandez);
        executor.execute(drGarcia);

        executor.shutdown();
    }
}