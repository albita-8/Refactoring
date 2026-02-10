public class Producto {

    private String nombre;
    private double precio;

    /**
     * @param nombre
     * @param precio
     */
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return
     */
    public double getPrecio() {
        return precio;
    }
}