
package clientes;

public class Empresa {
    private String cuit;
    private String razon_social;
    private String direccion;
    private String nombre;

    public Empresa(String cuit, String razon_social, String direccion, String nombre) {
        this.cuit = cuit;
        this.razon_social = razon_social;
        this.direccion = direccion;
        this.nombre = nombre;
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
    
}
