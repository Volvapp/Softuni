package bg.softuni._23_mvc_demo.service.employees.dtos;

import bg.softuni._23_mvc_demo.service.projects.dtos.ProjectImportDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeImportDto implements Serializable {
    @XmlElement(name = "first-name")
    private String firstName;
    @XmlElement(name = "last-name")
    private String lastName;
    @XmlElement
    private int age;
    @XmlElement(name = "project")
    private ProjectImportDTO projectImportDTO;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ProjectImportDTO getProjectImportDTO() {
        return projectImportDTO;
    }

    public void setProjectImportDTO(ProjectImportDTO projectImportDTO) {
        this.projectImportDTO = projectImportDTO;
    }
}
