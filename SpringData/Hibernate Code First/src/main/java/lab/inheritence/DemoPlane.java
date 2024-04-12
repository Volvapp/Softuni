package lab.inheritence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "planes")
public class DemoPlane extends DemoVehicle {
    private static final String PLANE_TYPE = "PLANE";
    @Column(name = "passenger_capacity")
    private int passengerCapacity;

    public DemoPlane(String model, BigDecimal price, String fuelType, int passengerCapacity) {
        super(PLANE_TYPE, model, price, fuelType);
        this.passengerCapacity = passengerCapacity;
    }


    public DemoPlane() {
    }
}
