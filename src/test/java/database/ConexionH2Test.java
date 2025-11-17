package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionH2Test {
    
    private Connection conn;

    public ConexionH2Test() {
        try {
            conn = DriverManager.getConnection("jdbc:h2:mem:test");
            System.out.println("database.ConexionH2Test.<init>(): Constructor (create database test)");
        } catch (SQLException ex) {
        }
    }
    
    public boolean createTable() {
        boolean ret=false;
        try (Statement stmt = conn.createStatement()) {
            ret = stmt.execute("create table clientes (id integer auto_increment, nombre varchar(50), apellido varchar(50), telefono varchar(30), email varchar(40))");
            if(ret) System.out.println("createTable: execute failed");
            else System.out.println("createTable: ok");
        } catch (SQLException ex) {
        }
        return ret;
    }
    
    public int agregarCliente(int id, String nombre, String apellido, String telefono, String email) {
        int ret = 0;
        try {
            String query = "insert into clientes (id, nombre, apellido, telefono, email) values (?, ?, ?, ?, ?);";
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setInt(1, id);
            pre.setString(2, nombre);
            pre.setString(3, apellido);
            pre.setString(4, telefono);
            pre.setString(5, email);
            ret = pre.executeUpdate();
        } catch (SQLException ex) {
        }
        return ret;
    }
    public int agregarClienteAuto(String nombre, String apellido, String telefono, String email) {
        int ret = 0;
        try {
            String query = "insert into clientes (nombre, apellido, telefono, email) values (?, ?, ?, ?);";
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, nombre);
            pre.setString(2, apellido);
            pre.setString(3, telefono);
            pre.setString(4, email);
            ret = pre.executeUpdate();
        } catch (SQLException ex) {
        }
        return ret;
    }
    
    public void listarClientes(int limit) {
        try {
            String query = "select * from clientes limit ? ;";
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setInt(1, limit);
            ResultSet rs = pre.executeQuery();
            while(rs.next()) {
                System.out.print("id: " + rs.getInt("id"));
                System.out.println(" N: " + rs.getString("nombre"));
            }
        } catch (SQLException ex) {
        }
        
    }
    
}
