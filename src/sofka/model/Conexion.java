
package sofka.model;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 * @author Kevin Moreno.
 */
public class Conexion {
    Connection cn;
    
    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sofka", "root", "");
            System.out.println("CONECTADO");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return cn;
    }
}
