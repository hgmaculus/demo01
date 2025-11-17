
package database;

public class ConexionH2Pruebas {
    public static void main(String[] args) {
        ConexionH2 c = new ConexionH2();
        c.initDB();
        c.seedDB();
        c.readDB();
    }
}
