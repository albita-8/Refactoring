import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private static final double DESCUENTO_GRAN_VOLUMEN = 0.05;

    private Cliente cliente;
    private List<Producto> productos;

    /**
     * @param cliente
     */
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    /**
     * @param producto
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    /**
     * @return
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @return
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * @return
     */
    public double calcularTotalNeto() {
        double total = 0;

        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        
        return total;
    }

    /**
     * @param total
     * @return
     */
    private boolean hayDescuento() {
        return calcularTotalNeto() > 3000;
    }
}