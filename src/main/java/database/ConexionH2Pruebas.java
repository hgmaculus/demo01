
package database;

import clientes.Cliente;

public class ConexionH2Pruebas {
    public static void main(String[] args) {
        try (ConexionH2 c = new ConexionH2()) {
            c.initDB();
            c.seedDB();
            c.agregarCliente(new Cliente(8, "Nuevo", "Apellido", "123131231", "asasd@hotmail.com"));
            c.agregarCliente(new Cliente(11, "Otro", "Apellido4", "456456456456", "ggggggggg@hotmail.com"));
            c.readDB();
            System.out.println(c.buscarClientePorNombre("Nuevo").toString());
            System.out.println(c.buscarClientePorNombre("Otro").toString());
            System.out.println("Empresas:");
          
            
        } catch (Exception e) {}
     
        System.out.println("Parte 2: ");
            try (ConexionH2 c = new ConexionH2()) {
            System.out.println(c.buscarClientePorNombre("Nuevo").toString());
            System.out.println(c.buscarClientePorNombre("Otro").toString());
         
        } catch (Exception e) {}

    }
}
