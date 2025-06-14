public class Ejercicio extends MaterialCurso {
    private boolean revisado = false;

    public Ejercicio(String titulo, String autor) {
        super(titulo, autor);
    }

    public void marcarRevisado() {
        revisado = true;
        System.out.println("✅ Ejercicio '" + titulo + "' marcado como revisado.");
    }

    public boolean isRevisado() {
        return revisado;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("📝 Ejercicio: " + titulo + " - Autor: " + autor + " - Revisado: " + revisado);
    }
}