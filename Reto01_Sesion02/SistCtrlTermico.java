import java.util.concurrent.Callable;

public class SistCtrlTermico implements Callable<String>{
    @Override
    public String call() throws Exception{
        Thread.sleep(1200);
        return "🔥 Control térmico: temperatura estable (22°C).";
    }
}