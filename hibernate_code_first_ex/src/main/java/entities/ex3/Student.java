package entities.ex3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends Information{
@Column(name = "average_grade")
    private double averageGrade;
@Column
    private String attendance;
@ManyToMany
    private Set<Course> courses;
}
