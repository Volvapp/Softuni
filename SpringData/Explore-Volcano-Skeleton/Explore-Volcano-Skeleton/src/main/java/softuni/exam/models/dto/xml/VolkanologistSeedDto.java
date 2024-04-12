package softuni.exam.models.dto.xml;

import softuni.exam.util.LocalDateAdapter;

import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;


@XmlRootElement(name = "volcanologist")
@XmlAccessorType(XmlAccessType.FIELD)
public class VolkanologistSeedDto {
    @XmlElement(name = "first_name")
    @Size(min = 2, max = 30)
    @NotNull
    private String firstName;
    @XmlElement(name = "last_name")
    @Size(min = 2, max = 30)
    @NotNull
    private String lastName;
    @XmlElement(name = "salary")
    @Positive
    @NotNull
    private double salary;
    @XmlElement(name = "age")
    @Min(18)
    @Max(80)
    @NotNull
    private int age;
    @XmlElement(name = "exploring_from")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate exploringFrom;
    @XmlElement(name = "exploring_volcano_id")
    private long volcanoId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getExploringFrom() {
        return exploringFrom;
    }

    public void setExploringFrom(LocalDate exploringFrom) {
        this.exploringFrom = exploringFrom;
    }

    public long getVolcanoId() {
        return volcanoId;
    }

    public void setVolcanoId(long volcanoId) {
        this.volcanoId = volcanoId;
    }
}
