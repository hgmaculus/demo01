package usuarios;

public class Usuario {
    private int id;
    private String nombre;
    private String clave;
    private int nivel;
    private boolean activo;

    public Usuario(int id, String nombre, String clave, String nivelDeAcceso, boolean act) {
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.activo = act;
        switch (nivelDeAcceso) {
            case "Vendedor":
                this.nivel = 1;
                break;
            case "Revisor":
                this.nivel = 2;
                break;
            case "Repositor":
                this.nivel = 3;
                break;
            case "Administrador":
                this.nivel = 4;
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public Usuario(String nombre, String clave, String nivelDeAcceso, boolean act) {
        this.id = 0;
        this.nombre = nombre;
        this.clave = clave;
        this.activo = act;
        switch (nivelDeAcceso) {
            case "Vendedor":
                this.nivel = 1;
                break;
            case "Revisor":
                this.nivel = 2;
                break;
            case "Repositor":
                this.nivel = 3;
                break;
            case "Administrador":
                this.nivel = 4;
                break;
            default:
                throw new AssertionError();
        }
    }
    public Usuario(int id, String nombre, String clave, int nivel, boolean act) {
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.nivel = nivel;
        this.activo = act;
    }
    public Usuario(String nombre, String clave, int nivel, boolean act) {
        this.nombre = nombre;
        this.clave = clave;
        this.nivel = nivel;
        this.activo = act;
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

    public String getNivelasString() {
        return switch (this.nivel) {
            case 1 -> "Vendedor";
            case 2 -> "Revisor";
            case 3 -> "Repositor";
            case 5 -> "Administrador";
            default -> "Nivel de usuario no valido";
        };
    }

    public void setNivel(int nivel) {
        if(nivel > 0 && nivel < 5) this.nivel = nivel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", clave=").append(clave);
        sb.append(", nivel=").append(getNivelasString());
        sb.append(", activo=").append(activo);
        sb.append('}');
        return sb.toString();
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}
