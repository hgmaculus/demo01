/* Author : H. Gabriel Máculus */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionH2 implements AutoCloseable {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ConexionH2.class.getName());
    private Connection conn;

    //private ResultSet rs;
    public ConexionH2() {
        try {
            conn = DriverManager.getConnection("jdbc:h2:mem:test");
        } catch (SQLException ex) {
            Logger.getLogger(Test_h2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int initDB() {
        int ret = 0;
        try (Statement stmt = conn.createStatement()) {
            ret = stmt.executeUpdate("create table cities (id integer, name varchar(50))");
            conn.commit();
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
            System.out.println("com.gnuino.h2_dbtest01.ConexionH2.seedDB(): executeUpdate: " + ret);
            //stmt.executeUpdate("insert into cities (id, name) values (2, \'Real del Pobre\'); ");
            conn.commit();
        } catch (SQLException e) {
        }
        return ret;
    }

    public void readDB() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from cities;");
            while (rs.next()) {
                System.out.println("id: " + rs.getString("id") + " name: " + rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Test_h2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void close() throws Exception {
        logger.info("Conexion H2 Close()");
    }

}
