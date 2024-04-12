package entities.ex2;

import entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {
@Column(nullable = false)
    private String name;
@Column(nullable = false)
    private String email;
@Column (name = "credit_card_number")
    private String creditCardNumber;
@OneToMany(mappedBy = "customer")
    private Set<Sale> sales;
}
