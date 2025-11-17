
package database;

public class TestH2 {
    
    public static void main(String[] args) {
        ConexionH2Test c = new ConexionH2Test();
        c.createTable();
        int t = c.agregarClienteAuto("G", "M", "1", "ga@gmail.com");
        t = c.agregarClienteAuto("B", "T", "2", "ga@gmail.com");
        if (t == 1) System.out.println("database.TestH2.main()" + t);
        c.listarClientes(3);
    }
}
