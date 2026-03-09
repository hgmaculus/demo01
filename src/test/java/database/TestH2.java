
package database;

import usuarios.Usuario;

public class TestH2 {
    
    public static void main(String[] args) {
        //ConexionH2Test c = new ConexionH2Test();
        ConexionH2 c = new ConexionH2();
        c.initDB();
        System.out.println(new Usuario("user1", "clave1", 3, true).getNivelasString());

        c.agregarUsuario(new Usuario("user1", "clave1", 4, true));
        c.agregarUsuario(new Usuario("user2", "clave2", 4, true));
        c.agregarUsuario(new Usuario("user3", "clave3", 4, true));
        c.readDB();
    }
}
