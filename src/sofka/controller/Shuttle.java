
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
public class Shuttle extends Ship implements Objetive {
    
    Conexion conn = new Conexion();
    Connection cn = conn.conectar();
    
    private String transportCapacity;
    private double height;
    private double power;

    public Shuttle() {
    }

    public Shuttle(Integer id, String name, double speed, Integer weight, String propulsionSystem, Integer tonThrust, String fuel, String description) {
        super(id, name, speed, weight, propulsionSystem, tonThrust, fuel, description);
    }

    public String getTransportCapacity() {
        return transportCapacity;
    }

    public void setTransportCapacity(String transportCapacity) {
        this.transportCapacity = transportCapacity;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
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
            statement.setInt(8, 1);
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
            
            
            String sql2 =  "INSERT INTO shuttle (transport_capacity, height, power, ship_idship)";
                   sql2 += "VALUES(?, ?, ?, ?);";
            PreparedStatement statement2 = (PreparedStatement) cn.prepareStatement(sql2);
            statement2.setString(1, getTransportCapacity());
            statement2.setDouble(2, getHeight());
            statement2.setDouble(3, getPower());
            statement2.setInt(4, Integer.parseInt(data[0]));
            statement2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Datos guardados con exito.");
            
            flag = true;
        } catch (Exception e) {
            System.out.println("Error al registrar nave tipo lanzadera." + e);
        }
        return flag;
    }

    @Override
    public boolean updateShip() {
        boolean flag = false;
        try {
            String sql =  "UPDATE SOFKA.SHIP SP, SOFKA.SHUTTLE SS ";
                   sql += "SET SP.name ='"+ getName() +"', SP.speed ='"+ getSpeed() +"', SP.weight ='"+ getWeight() +"', ";
                   sql += "SP.propulsion_system ='"+ getPropulsionSystem() +"', SP.ton_thrust ='"+ getTonThrust() +"', SP.fueL ='"+ getFuel() +"', SP.description ='"+ getDescription() +"', ";
                   sql += "SP.idtype ='"+ 1 +"', SS.transport_capacity ='"+ getTransportCapacity() +"', SS.height ='"+ getHeight() +"', SS.power ='"+ getPower() +"' ";
                   sql += "WHERE SP.IDSHIP = '" + getId() +"' AND SP.IDSHIP = SS.SHIP_IDSHIP";
            
            PreparedStatement statement = (PreparedStatement) cn.prepareStatement(sql);
            int index = statement.executeUpdate();
            
            if(index > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Un error ocurrió al actualizar la información: " + e);
        }
        return flag;
    }

    @Override
    public boolean deleteShip(Integer id) {
        boolean flag = false;
        
        try {
            String sql  = "DELETE FROM SOFKA.shuttle WHERE ship_idship ='"+ id +"';";
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
