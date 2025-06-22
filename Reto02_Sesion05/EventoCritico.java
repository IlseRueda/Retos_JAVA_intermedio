public class EventoCritico {
    public final int pacienteId;
    public final PrioridadVital tipo;
    public final String mensaje;

    public EventoCritico(int pacienteId, PrioridadVital tipo, String mensaje) {
        this.pacienteId = pacienteId;
        this.tipo = tipo;
        this.mensaje = mensaje;
    }
}