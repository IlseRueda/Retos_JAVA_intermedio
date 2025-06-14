import java.util.concurrent.Callable;

public class SistComun implements Callable<String>{
    @Override
    public String call() throws Exception{
        Thread.sleep(500);
        return "📡 Comunicaciones: enlace con estación terrestre establecido.";
    }
}