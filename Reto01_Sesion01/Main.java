import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<OrdenMasa> masa = Arrays.asList(
            new OrdenMasa("A123", 500),
            new OrdenMasa("A124", 750)
        );

        List<OrdenPersonal> personalizadas = Arrays.asList(
            new OrdenPersonal("P456", 100, "ClienteX"),
            new OrdenPersonal("P789", 150, "ClienteY")
        );

        List<OrdenPrototipo> prototipos = Arrays.asList(
            new OrdenPrototipo("T789", 10, "Diseño"),
            new OrdenPrototipo("T790", 5, "Pruebas")
        );

        GestorOrdenes.mostrarOrdenes(masa);
        GestorOrdenes.mostrarOrdenes(personalizadas);
        GestorOrdenes.mostrarOrdenes(prototipos);

        List<OrdenProduccion> todas = new ArrayList<>();
        todas.addAll(masa);
        todas.addAll(personalizadas);
        todas.addAll(prototipos);

        GestorOrdenes.procesarPersonalizadas(todas, 200);

        System.out.println("\nResumen total de órdenes:");
        System.out.println("Producción en masa: " + masa.size());
        System.out.println("Personalizadas: " + personalizadas.size());
        System.out.println("Prototipos: " + prototipos.size());
    }
}