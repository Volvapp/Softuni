package bg.softuni._23_mvc_demo.service.employees.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeXmlRootDto implements Serializable {
@XmlElement(name = "employee")
    private List<EmployeeImportDto> employeeImportDtos;

    public List<EmployeeImportDto> getEmployeeImportDtos() {
        return employeeImportDtos;
    }

    public void setEmployeeImportDtos(List<EmployeeImportDto> employeeImportDtos) {
        this.employeeImportDtos = employeeImportDtos;
    }
}
