public class OrdenPersonal extends OrdenProduccion {
    private String cliente;

    public OrdenPersonal(String codigo, int cantidad, String cliente) {
        super(codigo, cantidad);
        this.cliente = cliente;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("OrdenPersonalizada - Código: " + codigo + " - Cantidad: " + cantidad + " - Cliente: " + cliente);
    }

    public void agregarCostoAdicional(int costo) {
        System.out.println("Orden " + codigo + " ajustada con costo adicional de $" + costo);
    }
}