package clientes;

import java.util.ArrayList;
import java.util.List;

public class TestClientes {

    public static void main(String[] args) {
        List<Cliente> listaClientes = new ArrayList<>();
        
        listaClientes.add(new Cliente(1, "Gabriel", "Maculus", "", "", "", "", ""));
        listaClientes.add(new Cliente(2, "Esteban", "Perez", "", "", "", "", ""));
        listaClientes.add(new Cliente(3, "Claudio", "Paez", "", "", "", "", ""));
        
        listaClientes.forEach(System.out::println);
    }
    
}
