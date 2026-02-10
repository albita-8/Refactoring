import java.io.FileWriter;
import java.io.IOException;

public class App {

    private static final double TASA_IVA = 0.21;

    public static void main(String[] args) {

        System.out.println("INICIANDO SISTEMA DE PEDIDOS v2.0 (Refactorizado)...");

        Cliente cliente1 = new Cliente(
                "TechSolutions SL",
                "B12345678",
                "Calle Industria 55, Madrid"
        );

        Pedido pedido1 = new Pedido(cliente1);
        pedido1.agregarProducto(new Producto("Servidor Dell PowerEdge", 2500.00));
        pedido1.agregarProducto(new Producto("Licencia Windows Server", 800.00));
        pedido1.agregarProducto(new Producto("Cableado Estructurado", 250.50));

        procesarPedido(pedido1);

        Cliente cliente2 = new Cliente(
                "Libreria Moderna",
                "A98765432",
                "Av. Diagonal 200, Barcelona"
        );

        Pedido pedido2 = new Pedido(cliente2);
        pedido2.agregarProducto(new Producto("Pack Libros Escolares", 1200.00));
        pedido2.agregarProducto(new Producto("Estantería Metálica", 300.00));

        procesarPedido(pedido2);
    }

    public static void procesarPedido(Pedido pedido) {

        Cliente cliente = pedido.getCliente();

        System.out.println(String.format(
                "\nProcesando pedido para: %s\nID Cliente: %s",
                cliente.getNombre(),
                cliente.getId()
        ));

        int indice = 1;
        for (Producto producto : pedido.getProductos()) {
            System.out.println(String.format(
                    "Item %d: %s - %.2f EUR",
                    indice++, producto.getNombre(), producto.getPrecio()
            ));
        }

        double totalNeto = pedido.calcularTotalNeto();
        double totalConIva = totalNeto * (1 + TASA_IVA);

        System.out.println(String.format("Total Neto: %.2f EUR", totalNeto));
        System.out.println(String.format(
                "Total con IVA (%.0f%%): %.2f EUR",
                TASA_IVA * 100,
                totalConIva
        ));
        System.out.println("--------------------------------------------------");

        guardarFacturaEnArchivo(cliente, totalConIva);
    }

    public static void guardarFacturaEnArchivo(Cliente cliente, double totalConIva) {

        String nombreArchivo = String.format("pedido_%s.txt", cliente.getId());

        try (FileWriter writer = new FileWriter(nombreArchivo)) {

            writer.write("FACTURA\n");
            writer.write(String.format("Cliente: %s\n", cliente.getNombre()));
            writer.write(String.format("Direccion: %s\n", cliente.getDireccion()));
            writer.write(String.format("Total a pagar: %.2f EUR\n", totalConIva));

            System.out.println("Archivo guardado correctamente: " + nombreArchivo);

        } catch (IOException e) {
            System.out.println("Error al guardar la factura.");
            e.printStackTrace();
        }
    }
}