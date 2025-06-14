import java.util.concurrent.Callable;

public class SistSopVital implements Callable<String>{
    @Override
    public String call() throws Exception {
        Thread.sleep(800);
        return "🧪 Soporte vital: presión y oxígeno dentro de parámetros normales.";
    }
}