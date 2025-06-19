import reactor.core.publisher.Flux;
import java.time.Duration;

public class Main{
    public static void main(String[] args) throws InterruptedException{
        ServicioSensoresTrafico.iniciar();
        ServicioContaminacionAire.iniciar();
        ServicioAccidentes.iniciar();
        ServicioTrenesMaglev.iniciar();
        ServicioSemaforosInteligentes.iniciar();
        ServicioMonitorEventos.monitorerar();

        Thread.sleep(20000);
        
    }
}