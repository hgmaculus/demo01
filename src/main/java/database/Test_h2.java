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
        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:test")) {
                Statement stmt = conn.createStatement();
                stmt.execute("create table cities (id integer, name varchar(50))");
                stmt.executeUpdate("insert into cities (id, name) values (1, \'General Alvear\');");
                stmt.executeUpdate("insert into cities (id, name) values (2, \'Real del Padre\');");
                stmt.executeUpdate("insert into cities (id, name) values (3, \'Villa Atuel\');");
                conn.commit();
                ResultSet rs = stmt.executeQuery("select * from cities;");
                while(rs.next()) {
                    System.out.println("id: " + rs.getString("id") + " name: " + rs.getString("name"));
                }
            }
        catch (SQLException ex) {
            Logger.getLogger(Test_h2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
