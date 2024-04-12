package bg.softuni._23_mvc_demo.service.employees;

import jakarta.xml.bind.JAXBException;

public interface EmployeesService {

    void seedEmployees() throws JAXBException;

    boolean isImported();
}
