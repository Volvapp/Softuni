package lab.inheritence;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "vehicles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class DemoVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Basic
    private String type;
    @Basic
    private String model;
    @Basic
    private BigDecimal price;
    @Column(name = "fuel_type")
    private String fuelType;

    protected DemoVehicle(){}

    protected DemoVehicle(String type){
        this.type = type;
    }

    public DemoVehicle(String type, String model, BigDecimal price, String fuelType) {

        this.type = type;
        this.model = model;
        this.price = price;
        this.fuelType = fuelType;
    }
}
