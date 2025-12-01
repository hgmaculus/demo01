
package database;

import clientes.Cliente;

public class ConexionH2Pruebas {
    public static void main(String[] args) {
        ConexionH2 c = new ConexionH2();
        c.initDB();
        c.seedDB();
        c.readDB();
        c.agregarCliente(new Cliente(8, "Nuevo", "Apellido", "123131231", "asasd@hotmail.com"));
        c.readDB();
        System.out.println(c.buscarClientePorNombre("Nuevo").toString());
        
    }
}
