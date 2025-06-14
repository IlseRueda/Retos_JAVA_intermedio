import java.util.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) {
        List<Pedido> pedidos =Arrays.asList(
            new Pedido("Gerardo","domicilio", "555-254"),
            new Pedido("Lulu", "local", "555-47881"),
            new Pedido("Marta", "domicilio", null),
            new Pedido("Cinthia", "domicilio", "555-5232")
        );
        System.out.println("📦 Procesando pedidos a domicilio con teléfono...");

        pedidos.stream()
        .filter(p -> p.getTipoEntrega().equalsIgnoreCase("domicilio"))
        .map(Pedido::getTelefono)
        .flatMap(opt -> opt.map(Stream::of).orElseGet(Stream::empty))
        .map(numero -> "📞 Confirmación enviada al número: " + numero)
        .forEach(System.out::println);
    }
}