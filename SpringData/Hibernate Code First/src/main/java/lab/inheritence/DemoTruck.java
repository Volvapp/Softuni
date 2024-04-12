package lab.inheritence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "trucks")
public class DemoTruck extends DemoVehicle {
    private static final String TRUCK_TYPE = "TRUCK";
    @Column(name = "laod_capacity")
    private double loadCapacity;

    public DemoTruck(String model, BigDecimal price, String fuelType, double loadCapacity) {
        super(TRUCK_TYPE, model, price, fuelType);
        this.loadCapacity = loadCapacity;
    }

    public DemoTruck() {

    }
}
