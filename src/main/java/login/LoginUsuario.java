package login;


public class LoginUsuario {

    private String usuario, clave;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoginUsuario{");
        sb.append("usuario=").append(usuario);
        sb.append(", clave=").append(clave);
        sb.append('}');
        return sb.toString();
    }

    public LoginUsuario(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
}
