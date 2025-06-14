import java.util.*;
import java.util.concurrent.*;


public class Main{
    public static void main(String[] args) throws Exception {
        System.out.println("🚀 Simulación de misión espacial iniciada...");
        ExecutorService executor = Executors.newFixedThreadPool(4);

        List<Callable<String>> tareas = Arrays.asList(
            new SistComun(),
            new SistSopVital(),
            new SistCtrlTermico(),
            new SistNav()
        );
        List<Future<String>> resultados = executor.invokeAll(tareas);
        for (Future<String> resultado : resultados) {
            System.out.println(resultado.get());
        }
        executor.shutdown();
        System.out.println("✅ Todos los sistemas reportan estado operativo.");
    }
}