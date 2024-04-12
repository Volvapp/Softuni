package entities.ex2;

import entities.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {
    @Column
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToOne
    @JoinColumn(name = "location_id")
    private StoreLocation storeLocation;
}
