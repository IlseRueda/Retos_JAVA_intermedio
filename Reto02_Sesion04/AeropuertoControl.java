import java.util.concurrent.*;

public class AeropuertoControl {

    public CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia();
            System.out.println("🛬 Verificación pista completada: ✅ Disponible");
            return true; // cambia a false para probar una denegación
        });
    }

    public CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia();
            System.out.println("🌤️ Verificación clima completada: ✅ En buenas condiciones ");
            return true;
        });
    }

    public CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia();
            System.out.println("✈️ Verificación tráfico aéreo completada: ✅ Sin congestión");
            return true;
        });
    }

    public CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia();
            System.out.println("🧑‍✈️ Verificación personal en tierra: ✅ Disponible");
            return true;
        });
    }

    private void simularLatencia() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 3000));
        } catch (InterruptedException e) {
            throw new RuntimeException("⛔ Interrupción simulada");
        }
    }

    public void procesarAterrizaje() {
        CompletableFuture<Boolean> pista = verificarPista();
        CompletableFuture<Boolean> clima = verificarClima();
        CompletableFuture<Boolean> trafico = verificarTraficoAereo();
        CompletableFuture<Boolean> personal = verificarPersonalTierra();

        CompletableFuture.allOf(pista, clima, trafico, personal)
            .thenApply(v -> pista.join() && clima.join() && trafico.join() && personal.join())
            .thenAccept(todasOk -> {
                if (todasOk) {
                    System.out.println("🛬 Aterrizaje autorizado: todas las condiciones óptimas.");
                } else {
                    System.out.println("🚫 Aterrizaje denegado: condiciones no óptimas.");
                }
            })
            .exceptionally(ex -> {
                System.out.println("⚠️ Error en el proceso de verificación: " + ex.getMessage());
                return null;
            });
    }

    public static void main(String[] args) {
        AeropuertoControl control = new AeropuertoControl();
        control.procesarAterrizaje();

        // Para dar tiempo a que las tareas asincrónicas se completen
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}