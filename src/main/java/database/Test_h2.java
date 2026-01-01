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
        long endTime;
        long startTime = System.currentTimeMillis();
        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:test")) {
            Statement stmt = conn.createStatement();
            boolean ret;
            //ret = stmt.execute("create table cities (id integer, name varchar(50))");
            
            //if(ret) System.out.println("execute failed");
            //ret = stmt.execute("create table clientes (id integer, nombre varchar(50), apellido varchar(50), telefono varchar(30), email varchar(40))");
            //if(ret) System.out.println("execute failed");
            ret = stmt.execute("create table empresas (id bigint auto_increment primary key, cuit varchar(50) not null unique, razon_social varchar(50))");
            if(ret) System.out.println("execute failed empresas");
            stmt.executeUpdate("insert into empresas (cuit, razon_social) values (\'20293842729\', \'Razon Social\');");
            if(ret) System.out.println("execute failed insert into empresas");
            stmt.executeUpdate("insert into empresas (cuit, razon_social) values (\'20293842729\', \'Razon Social\');");
            if(ret) System.out.println("execute failed insert into empresas");
            
            ResultSet rs;
 
            rs = stmt.executeQuery("select * from empresas;");
            while (rs.next()) {
                System.out.println("ID: " + rs.getString("id") 
                        + " CUIT: " + rs.getString("cuit")
                        + " Razon Social: " + rs.getString("razon_social")
                );
            }
            endTime = System.currentTimeMillis();
            System.out.println("Total execution time(create table): " + (endTime - startTime) + "ms");
            //startTime = System.currentTimeMillis();
            /*
            stmt.executeUpdate("insert into cities (id, name) values (1, \'General Alvear\');");
            stmt.executeUpdate("insert into cities (id, name) values (2, \'Real del Padre\');");
            stmt.executeUpdate("insert into cities (id, name) values (3, \'Villa Atuel\');");
            stmt.executeUpdate("insert into cities (id, name) values (4, \'Atuel Norte\');");
            stmt.executeUpdate("insert into cities (id, name) values (5, \'San Pedro del Atuel \');");
            //conn.commit();
            */
            //endTime = System.currentTimeMillis();
            //System.out.println("Total execution time(insert into table): " + (endTime - startTime) + "ms");
            /*
            stmt.executeUpdate("insert into clientes (id, nombre, apellido, telefono, email) values "
                    + "(1, \'Gabriel\', \'Maculus\', \'2625525130\', \'gabrielmaculus@gmail.com\'), "
                    + "(2, \'Luis\', \'Garcia\', \'2625551122\', \'luisgarcia@gmail.com\'), "
                    + "");*/
            /*
            stmt.executeUpdate(
                    "insert into clientes (id, nombre, apellido, telefono, email) "
                            + "values "
                            + "(1, \'Gabriel\', \'Maculus\', \'2625525130\', \'gabrielmaculus@gmail.com\');");
            
            startTime = System.currentTimeMillis();

            rs = stmt.executeQuery("select * from cities;");

            endTime = System.currentTimeMillis();
            System.out.println("Total execution time(select *): " + (endTime - startTime) + "ms");
            while (rs.next()) {
                System.out.println("id: " + rs.getString("id") + " name: " + rs.getString("name"));
            }
            */
            /* finish get cities */
            /*
            rs = stmt.executeQuery("select * from clientes;");
            while (rs.next()) {
                System.out.println("id: " + rs.getString("id") 
                        + " nombre: " + rs.getString("nombre")
                        + " apellido: " + rs.getString("apellido")
                        + " telefono: " + rs.getString("telefono")
                        + " email: " + rs.getString("email")
                );
            }
            */
        } catch (SQLException ex) {
            Logger.getLogger(Test_h2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
