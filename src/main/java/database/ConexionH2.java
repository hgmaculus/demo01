/* Author : H. Gabriel Máculus */
// This object act like a singleton, each new object connect with same database and data
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import clientes.Cliente;
import usuarios.Usuario;
import empresas.Empresa;

public class ConexionH2 implements AutoCloseable {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ConexionH2.class.getName());
    private Connection conn;
    
    public ConexionH2() {
        try {
            conn = DriverManager.getConnection("jdbc:h2:mem:test");
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    public int initDB() {
        int ret = 0;
        try (Statement stmt = conn.createStatement()) {
            ret = stmt.executeUpdate("create table cities (id integer, name varchar(50))");
            System.out.println("database.ConexionH2.initDB() : Create table cities");
        } catch (SQLException e) {
        }
        try (Statement stmt = conn.createStatement()) {
            ret = stmt.executeUpdate("create table clientes (id integer, nombre varchar(50), apellido varchar(50), telefono varchar(30), email varchar(40))");
            System.out.println("database.ConexionH2.initDB() : Create table clientes");
        } catch (SQLException e) {
        }
        try (Statement stmt = conn.createStatement()) {
            ret = stmt.executeUpdate("create table usuarios (id integer, nombre varchar(50), clave varchar(50), nivel integer)");
            System.out.println("database.ConexionH2.initDB() : Create table usuarios");
        } catch (SQLException e) {
        }
        try (Statement stmt = conn.createStatement()) {
            ret = stmt.executeUpdate("create table empresas (id integer, cuit varchar(20), razon_social varchar(50), direccion varchar(80), nombre varchar(40))");
            System.out.println("database.ConexionH2.initDB() : Create table empresas");
        } catch (SQLException e) {
        }
        return ret;
    }

    public int seedDB() {
        int ret = 0;
        try (Statement stmt = conn.createStatement()) {
            // insert multiples values
            ret = stmt.executeUpdate("insert into cities (id, name) values "
                    + "(1, \'General Alvear\'), "
                    + "(2, \'Real del Padre\'), "
                    + "(3, \'Villa Atuel\'); "
                    + "");
            System.out.println("com.gnuino.h2_dbtest01.ConexionH2.seedDB(cities): executeUpdate: " + ret);
            //stmt.executeUpdate("insert into cities (id, name) values (2, \'Real del Pobre\'); ");
            conn.commit();
        } catch (SQLException e) {
        }
        // Seed Clientes
        try (Statement stmt = conn.createStatement()) {
            // insert one value
            ret = stmt.executeUpdate("insert into clientes (id, nombre, apellido, telefono, email) values "
                    + "(1, \'Gabriel\', \'Maculus\', \'2625525130\', \'gabrielmaculus@gmail.com\'); "
                    );
            System.out.println("ConexionH2.seedDB(clientes): executeUpdate: " + ret);  
            ret = stmt.executeUpdate("insert into clientes (id, nombre, apellido, telefono, email) values "
                    + "(1, \'Luis\', \'Gonzalez\', \'262533455\', \'ninguno@gmail.com\'); "
                    );
            System.out.println("ConexionH2.seedDB(clientes): executeUpdate: " + ret);  
            
            
        } catch (SQLException e) {
            System.out.println("database.ConexionH2.seedDB() Exception: insert into clientes " + e.getMessage());
        }
        // Seed Usuarios
        try (Statement stmt = conn.createStatement()) {
            // insert multiples values
            ret = stmt.executeUpdate("insert into usuarios (id, nombre, clave, nivel) values "
                    + "(1, \'gabriel\', \'ninguna\', 0), "
                    + "(2, \'luis\', \'Garcia \', 1); "
                    + "");
            System.out.println("ConexionH2.seedDB(usuarios): executeUpdate: " + ret);
        } catch (SQLException e) {
            System.out.println("database.ConexionH2.seedDB() Exception: insert into usuarios");
        }
        // Seed Empresas
        try (Statement stmt = conn.createStatement()) {
            // insert multiples values
            ret = stmt.executeUpdate("insert into empresas (id, cuit, razon_social, nombre) values "
                    + "(1, \'20293339999\', \'Gnuino System\', \'Ningun nombre\'), "
                    + "(2, \'290002227771\', \'ninguna\', \'Nombre empresa 2\'); "
                    + "");
            System.out.println("ConexionH2.seedDB(empresas): executeUpdate: " + ret);
        } catch (SQLException e) {
            System.out.println("database.ConexionH2.seedDB() Exception: insert into empresas");
        }
        return ret;
    }

    public void readDB() {
        try (Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery("select * from cities;");
            while (rs.next()) {
                System.out.println("id: " + rs.getString("id") + " name: " + rs.getString("name"));
            }
            
            rs = stmt.executeQuery("select * from clientes;");
            System.out.println("Lista Clientes");
            while (rs.next()) {
                System.out.println("id: " + rs.getString("id") + " name: " + rs.getString("nombre"));
            }
            rs = stmt.executeQuery("select * from usuarios;");
            System.out.println("Lista usuarios");
            while (rs.next()) {
                System.out.println("id: " + rs.getString("id") + " name: " + rs.getString("nombre"));
            }
            rs = stmt.executeQuery("select * from empresas;");
            System.out.println("Lista Empresas");
            while (rs.next()) {
                System.out.println("id: " + rs.getString("cuit") + " name: " + rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Test_h2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void close() {
        logger.info("Calling AutoCloseable interface ConexionH2 Close()");
    }

    public int agregarCliente(Cliente nuevoCliente) {
        int ret = 0;
        try {
            String query = "insert into clientes (id, nombre, apellido, telefono, email) values (?, ?, ?, ?, ?);";
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setInt(1, nuevoCliente.getId());
            pre.setString(2, nuevoCliente.getNombre());
            pre.setString(3, nuevoCliente.getApellido());
            pre.setString(4, nuevoCliente.getTelefono());
            pre.setString(5, nuevoCliente.getEmail());
            ret = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Test_h2.class.getName()).log(Level.SEVERE, "agregarCliente", ex);
        }
        return ret;
    }
    
    //"create table usuarios (id integer, nombre varchar(50), clave varchar(50), nivel integer)"
    public boolean agregarUsuario(Usuario u) {
        int ret = 0;
        try {
            String query = "insert into usuarios(nombre, clave, nivel) values (?, ?, ?);";
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, u.getNombre());
            pre.setString(2, u.getClave());
            pre.setInt(3, u.getNivel());
            ret = pre.executeUpdate();
            if(ret == 0) System.out.println("database.ConexionH2.agregarUsuario(): Failed!");
        } catch (SQLException ex) {
            Logger.getLogger(Test_h2.class.getName()).log(Level.SEVERE, "agregarCliente", ex);
        }
        return true;
    }
    public int agregarEmpresa(Empresa nuevaEmpresa) {
        int ret = 0;
        try {
            String query = "insert into empresas (id, cuit, razon_social, nombre) values (?, ?, ?, ?);";
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setInt(1, nuevaEmpresa.getId());
            pre.setString(2, nuevaEmpresa.getCuit());
            pre.setString(3, nuevaEmpresa.getRazon_social());
            pre.setString(4, nuevaEmpresa.getNombre());
            ret = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Test_h2.class.getName()).log(Level.SEVERE, "agregarCliente", ex);
        }
        return ret;
    }
    public Cliente buscarClientePorNombre(String nombre) {
        Cliente objetivo = null;
        try {
            String query = "select * from clientes where nombre like ? limit 1;";
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, nombre);
            ResultSet rs = pre.executeQuery();
            if(rs.next()) objetivo = new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("telefono"), rs.getString("email"));
        } catch (SQLException ex) {
            Logger.getLogger(Test_h2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objetivo;
    }
    
}
