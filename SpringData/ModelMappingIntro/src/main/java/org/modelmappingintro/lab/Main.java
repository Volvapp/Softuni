package org.modelmappingintro.lab;

import org.modelmapper.ModelMapper;
import org.modelmappingintro.lab.models.Employee;
import org.modelmappingintro.lab.models.EmployeeDto;
import org.modelmappingintro.lab.models.ManagerDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ModelMapper mapper = new ModelMapper();

        Employee manager = new Employee(
                "Manager", "LManager", BigDecimal.valueOf(11), LocalDate.now(), "Plovdiv",
                WorkStatus.PAID_TIME_OFF, null, List.of());

        Employee employee = new Employee("Pesho", "Yordanov", BigDecimal.ONE, LocalDate.now(),
                "Sofia", WorkStatus.PRESENT, manager, List.of());

        manager.setEmployees(List.of(employee));

        EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);
        ManagerDto managerDto = mapper.map(manager, ManagerDto.class);

        System.out.println(employeeDto);
        System.out.println(managerDto);
    }
}
