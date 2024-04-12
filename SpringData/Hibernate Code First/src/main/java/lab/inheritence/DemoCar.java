package lab.inheritence;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "cars")
public class DemoCar extends DemoVehicle {
    private static final String CAR_TYPE = "CAR";
    @Basic
    private int seats;

    public DemoCar(String model, BigDecimal price, String fuelType, int seats) {
        super(CAR_TYPE, model, price, fuelType);
        this.seats = seats;
    }

    public DemoCar() {

    }
}
