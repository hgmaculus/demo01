
package empresas;

public class Empresa {
    private int id;
    private String cuit;
    private String razon_social;
    private String direccion;
    private String nombre;
    private String telefono;

    public Empresa(String cuit, String razon_social, String direccion, String nombre, String telefono) {
        this.cuit = cuit;
        this.razon_social = razon_social;
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    public String getCuit() {
        return cuit;
    }
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
    public String getRazon_social() {
        return razon_social;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empresa{");
        sb.append("cuit=").append(cuit);
        sb.append(", razon_social=").append(razon_social);
        sb.append(", direccion=").append(direccion);
        sb.append(", nombre=").append(nombre);
        sb.append('}');
        return sb.toString();
    }
    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
