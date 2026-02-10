import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private static final double DESCUENTO_GRAN_VOLUMEN = 0.05;

    private Cliente cliente;
    private List<Producto> productos;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double calcularTotalNeto() {
        double total = 0;

        for (Producto producto : productos) {
            total += producto.getPrecio();
        }

        if (total > 3000) {
            total *= (1 - DESCUENTO_GRAN_VOLUMEN);
        }

        return total;
    }
}