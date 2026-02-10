public class Cliente {

    private String nombre;
    private String id;
    private String direccion;

    /**
     * @param nombre
     * @param id
     * @param direccion
     */
    public Cliente(String nombre, String id, String direccion) {
        this.nombre = nombre;
        this.id = id;
        this.direccion = direccion;
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
    public String getId() {
        return id;
    }

    /**
     * @return
     */
    public String getDireccion() {
        return direccion;
    }
}