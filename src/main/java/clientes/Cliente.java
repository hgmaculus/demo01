package clientes;

public class Cliente {

    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    public Cliente(int id, String nombre, String apellido, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }


    public Cliente(int id, String nombre, String apellido, String telefono) {
        this(id, nombre, apellido, telefono, null); // Llama al constructor principal con email = null
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // --- Método toString para una representación en texto del objeto ---
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + (email != null ? email : "N/A") + '\'' + // Muestra "N/A" si el email es null
                '}';
    }
}