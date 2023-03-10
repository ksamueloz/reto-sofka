
package sofka.controller;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import sofka.model.Conexion;

/**
 * @author Kevin Moreno.
 */
public class Unmanned extends Ship implements Objetive {
    
    Conexion conn = new Conexion();
    Connection cn = conn.conectar();
    
    private int number_engines;

    public Unmanned() {
    }

    public Unmanned(Integer id, String name, double speed, Integer weight, String propulsionSystem, Integer tonThrust, String fuel, String description) {
        super(id, name, speed, weight, propulsionSystem, tonThrust, fuel, description);
    }
    
    
    
    public Integer getNumberEngines() {
        return number_engines;
    }

    public void setNumberEngines(int number_engines) {
        this.number_engines = number_engines;
    }
        
    @Override
    public boolean createShip() {
        boolean flag = false;
        try {
            String sql =  "INSERT INTO ship (name, speed, weight, propulsion_system, ton_thrust, fuel, description, idtype)";
                   sql += "VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
            
            PreparedStatement statement = (PreparedStatement) cn.prepareStatement(sql);
            statement.setString(1, getName());
            statement.setDouble(2, getSpeed());
            statement.setInt(3, getWeight());
            statement.setString(4, getPropulsionSystem());
            statement.setInt(5, getTonThrust());
            statement.setString(6, getFuel());
            statement.setString(7, getDescription());
            statement.setInt(8, 3);
            statement.executeUpdate();
            
            String consult = "SELECT MAX(idship) FROM ship";
            String data[] = new String[1];
            Statement statementConsult;
            
            try {
                statementConsult = (Statement) cn.createStatement();
                // Se importa la libreria: import java.sql.* para que funcione el ResultSet.
                ResultSet result = statementConsult.executeQuery(consult);
                while (result.next()) {
                    data[0] = result.getString(1);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
            
            
            String sql2 =  "INSERT INTO unmanned (number_engines, ship_idship) ";
                   sql2 += "VALUES(?, ?);";
            PreparedStatement statement2 = (PreparedStatement) cn.prepareStatement(sql2);
            statement2.setInt(1, getNumberEngines());
            statement2.setInt(2, Integer.parseInt(data[0]));
            statement2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Datos guardados con exito.");
            
            flag = true;
        } catch (Exception e) {
            System.out.println("Error al registrar nave tipo NO Tripulada." + e);
        }
        return flag;
    }

    @Override
    public boolean updateShip() {
        boolean flag = false;
        try {
            String sql =  "UPDATE SOFKA.SHIP SP, SOFKA.UNMANNED SS ";
                   sql += "SET SP.name ='"+ getName() +"', SP.speed ='"+ getSpeed() +"', SP.weight ='"+ getWeight() +"', ";
                   sql += "SP.propulsion_system ='"+ getPropulsionSystem() +"', SP.ton_thrust ='"+ getTonThrust() +"', SP.fueL ='"+ getFuel() +"', SP.description ='"+ getDescription() +"', ";
                   sql += "SP.idtype ='"+ 3 +"', SS.number_engines ='"+ getNumberEngines() +"' ";
                   sql += "WHERE SP.IDSHIP = '" + getId() +"' AND SP.IDSHIP = SS.SHIP_IDSHIP";
            
            PreparedStatement statement = (PreparedStatement) cn.prepareStatement(sql);
            int index = statement.executeUpdate();
            
            if(index > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Un error ocurri?? al actualizar la informaci??n: " + e);
        }
        return flag;
    }

    @Override
    public boolean deleteShip(Integer id) {
        boolean flag = false;
        
        try {
            String sql  = "DELETE FROM SOFKA.unmanned WHERE ship_idship ='"+ id +"';";
            String sql2 = "DELETE FROM SOFKA.ship WHERE idship ='"+ id +"';";
            
            PreparedStatement statement = (PreparedStatement) cn.prepareStatement(sql);
            PreparedStatement statement2 = (PreparedStatement) cn.prepareStatement(sql2);
            
            int index = statement.executeUpdate();
            int index2 = statement2.executeUpdate();
            
            if (index > 0 && index2 > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e);
        }
        return flag;
    } 
}
