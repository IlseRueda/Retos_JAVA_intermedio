import java.util.List;

public class GestorOrdenes {
    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
        System.out.println("\n Órdenes registradas:");
        for (OrdenProduccion orden : lista) {
            orden.mostrarResumen();
        }
    }

    public static void procesarPersonalizadas(List<? super OrdenPersonal> lista, int costoAdicional) {
        System.out.println("\n Procesando órdenes personalizadas...");
        for (Object obj : lista) {
            if (obj instanceof OrdenPersonal) {
                ((OrdenPersonal) obj).agregarCostoAdicional(costoAdicional);
            }
        }
    }
}