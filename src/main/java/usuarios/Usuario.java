package usuarios;

public class Usuario {
    private int id;
    private String nombre;
    private String clave;
    private int nivel;

    public Usuario(int id, String nombre, String clave, int nivel) {
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.nivel = nivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", clave=").append(clave);
        sb.append(", nivel=").append(nivel);
        sb.append('}');
        return sb.toString();
    }
    
}
