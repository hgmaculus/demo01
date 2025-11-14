
package clientes;

public class Empresa extends ClienteBase {
    private String cuit;
    private String razon_social;

    public Empresa(String cuit, String razon_social, String direccion, int id, String nombre) {
        super(id, nombre, direccion);
        this.cuit = cuit;
        this.razon_social = razon_social;
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

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }
    
}
