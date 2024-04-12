package entities.ex2;

import entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "store_locations")
public class StoreLocation extends BaseEntity {
@Column(name = "location_name", nullable = false)
    private String locationName;
@OneToOne(mappedBy = "storeLocation")
    private Sale sale;
}
