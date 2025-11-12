package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
    Test h2 database without dependencies
 */
public class Test_h2 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long endTime;
        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:test")) {
            Statement stmt = conn.createStatement();
            boolean ret = stmt.execute("create table cities (id integer, name varchar(50))");
            conn.commit();
            if(ret) System.out.println("execute failed");
            ret = stmt.execute("create table clientes (id integer, nombre varchar(50), apellido varchar(50), telefono varchar(30), email varchar(40))");
            if(ret) System.out.println("execute failed");
            conn.commit();
            endTime = System.currentTimeMillis();
            System.out.println("Total execution time(create table): " + (endTime - startTime) + "ms");
            startTime = System.currentTimeMillis();
            
            stmt.executeUpdate("insert into cities (id, name) values (1, \'General Alvear\');");
            stmt.executeUpdate("insert into cities (id, name) values (2, \'Real del Padre\');");
            stmt.executeUpdate("insert into cities (id, name) values (3, \'Villa Atuel\');");
            stmt.executeUpdate("insert into cities (id, name) values (4, \'Atuel Norte\');");
            stmt.executeUpdate("insert into cities (id, name) values (5, \'San Pedro del Atuel \');");
            conn.commit();
            
            endTime = System.currentTimeMillis();
            System.out.println("Total execution time(insert into table): " + (endTime - startTime) + "ms");
            /*
            stmt.executeUpdate("insert into clientes (id, nombre, apellido, telefono, email) values "
                    + "(1, \'Gabriel\', \'Maculus\', \'2625525130\', \'gabrielmaculus@gmail.com\'), "
                    + "(2, \'Luis\', \'Garcia\', \'2625551122\', \'luisgarcia@gmail.com\'), "
                    + "");*/
            stmt.executeUpdate(
                    "insert into clientes (id, nombre, apellido, telefono, email) "
                            + "values "
                            + "(1, \'Gabriel\', \'Maculus\', \'2625525130\', \'gabrielmaculus@gmail.com\');");
            conn.commit();
            startTime = System.currentTimeMillis();

            ResultSet rs = stmt.executeQuery("select * from cities;");

            endTime = System.currentTimeMillis();
            System.out.println("Total execution time(select *): " + (endTime - startTime) + "ms");
            while (rs.next()) {
                System.out.println("id: " + rs.getString("id") + " name: " + rs.getString("name"));
            }
            
            /* finish get cities */
 
            rs = stmt.executeQuery("select * from clientes;");
            while (rs.next()) {
                System.out.println("id: " + rs.getString("id") 
                        + " nombre: " + rs.getString("nombre")
                        + " apellido: " + rs.getString("apellido")
                        + " telefono: " + rs.getString("telefono")
                        + " email: " + rs.getString("email")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(Test_h2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
