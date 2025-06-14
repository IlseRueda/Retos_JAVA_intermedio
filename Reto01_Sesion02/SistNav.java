import java.util.concurrent.Callable;

public class SistNav implements Callable<String>{
    @Override
    public String call() throws Exception{
        Thread.sleep(1000);
        return "🛰️ Navegación: trayectoria corregida con éxito.";
    }
}