public class Principal {
    public static void main(String[] args) throws InterruptedException {
        ServicioUCI.flujoTotal()
            .subscribe(evento -> 
                System.out.println("⚠️ Paciente " + evento.pacienteId + " - " + evento.mensaje));

        Thread.sleep(30000); // Ejecuta por 30 segundos
    }
}