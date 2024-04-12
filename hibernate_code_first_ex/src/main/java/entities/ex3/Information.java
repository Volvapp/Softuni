package entities.ex3;

import entities.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "information")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Information extends BaseEntity {
@Column(name = "first_name", nullable = false)
private String firstName;
@Column(name = "last_name", nullable = false)
private String lastName;
@Column
private String phone;
}
