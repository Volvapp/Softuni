package org.modelmappingintro;

import org.modelmapper.ModelMapper;
import org.modelmappingintro.DTOs.BasicEmployeeDTO;
import org.modelmappingintro.models.Address;
import org.modelmappingintro.models.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class MainRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Address address = new Address("Bg", "Plovdiv", "Maritsa");
        Employee employee = new Employee("first", "last", BigDecimal.valueOf(10), address);

        ModelMapper modelMapper = new ModelMapper();
        BasicEmployeeDTO basicEmployeeDTO = modelMapper.map(employee, BasicEmployeeDTO.class);

        System.out.println();
    }
}
