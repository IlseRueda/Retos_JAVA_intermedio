public class Paciente {
    public final int id;
    public final int frecuenciaCardiaca;
    public final int presionSistolica;
    public final int presionDiastolica;
    public final int oxigeno;

    public Paciente(int id, int fc, int ps, int pd, int spo2) {
        this.id = id;
        this.frecuenciaCardiaca = fc;
        this.presionSistolica = ps;
        this.presionDiastolica = pd;
        this.oxigeno = spo2;
    }
}