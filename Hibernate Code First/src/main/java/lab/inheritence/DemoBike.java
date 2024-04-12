package lab.inheritence;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "bikes")
public class DemoBike extends DemoVehicle {
    private static final String BIKE_TYPE = "BIKE";
    public DemoBike(String model, BigDecimal price, String fuelType) {
        super(BIKE_TYPE, model, price, fuelType);
    }

    public DemoBike() {

    }
}
