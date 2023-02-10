
package sofka.controller;

import com.mysql.jdbc.Connection;
import sofka.model.Conexion;

/**
 * @author Kevin Moreno.
 */
public abstract class Ship {
    protected Integer id;
    protected String name;
    protected double speed;
    protected Integer weight;
    protected String propulsionSystem;
    protected Integer tonThrust;
    protected String fuel;
    protected String description;

    public Ship() {
    }

    public Ship(Integer id, String name, double speed, Integer weight, String propulsionSystem, Integer tonThrust, String fuel, String description) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.weight = weight;
        this.propulsionSystem = propulsionSystem;
        this.tonThrust = tonThrust;
        this.fuel = fuel;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
       
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getPropulsionSystem() {
        return propulsionSystem;
    }

    public void setPropulsionSystem(String propulsionSystem) {
        this.propulsionSystem = propulsionSystem;
    }

    public Integer getTonThrust() {
        return tonThrust;
    }

    public void setTonThrust(Integer tonThrust) {
        this.tonThrust = tonThrust;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public abstract boolean createShip();
    public abstract boolean updateShip();

}
