package entities.ex3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher extends Information{
@Column (nullable = false)
    private String email;
@Column(name = "salary_per_hour", nullable = false)
    private double salaryPerHour;
}
