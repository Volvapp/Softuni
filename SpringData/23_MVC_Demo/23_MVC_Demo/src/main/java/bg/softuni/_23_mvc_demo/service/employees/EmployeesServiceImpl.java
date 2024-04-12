package bg.softuni._23_mvc_demo.service.employees;

import bg.softuni._23_mvc_demo.persistence.entities.Employee;
import bg.softuni._23_mvc_demo.persistence.repositories.EmployeesRepository;
import bg.softuni._23_mvc_demo.persistence.repositories.ProjectsRepository;
import bg.softuni._23_mvc_demo.service.employees.dtos.EmployeeImportDto;
import bg.softuni._23_mvc_demo.service.employees.dtos.EmployeeXmlRootDto;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.File;
@Service
public class EmployeesServiceImpl implements EmployeesService{
    private static final String FILE_PATH = "src/main/resources/files/xmls/employees.xml";
    private final EmployeesRepository employeesRepository;
    private final ModelMapper modelMapper;
    private final ProjectsRepository projectsRepository;

    public EmployeesServiceImpl(EmployeesRepository employeesRepository, ModelMapper modelMapper, ProjectsRepository projectsRepository) {
        this.employeesRepository = employeesRepository;
        this.modelMapper = modelMapper;
        this.projectsRepository = projectsRepository;
    }

    @Override
    public void seedEmployees() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(EmployeeXmlRootDto.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        EmployeeXmlRootDto employeeXmlRootDto = (EmployeeXmlRootDto) unmarshaller.unmarshal(new File(FILE_PATH));

        for (EmployeeImportDto employeeImportDto : employeeXmlRootDto.getEmployeeImportDtos()) {
            Employee employee = this.modelMapper.map(employeeImportDto, Employee.class);

            employee.setProject(this.projectsRepository.findByName(employee.getProject().getName()).orElse(null));
            employeesRepository.saveAndFlush(employee);
        }
    }

    @Override
    public boolean isImported() {
        return this.employeesRepository.count() > 0;
    }
}
