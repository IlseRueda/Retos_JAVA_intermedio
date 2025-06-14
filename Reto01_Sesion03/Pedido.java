import java.util.Optional;

public class Pedido{
    private String cliente;
    private String tipoEntrega;
    private String telefono;

    public Pedido(String cliente, String tipoEntrega, String telefono) {
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.telefono = telefono;
    }

    public String getCliente(){
        return cliente;
    }
    public String getTipoEntrega(){
        return tipoEntrega;
    }
    public Optional<String> getTelefono(){
        return Optional.ofNullable(telefono);
    }
}