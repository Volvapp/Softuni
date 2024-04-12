package bg.softuni._23_mvc_demo.service.projects;

import bg.softuni._23_mvc_demo.persistence.entities.Company;
import bg.softuni._23_mvc_demo.persistence.entities.Project;
import bg.softuni._23_mvc_demo.persistence.repositories.CompaniesRepository;
import bg.softuni._23_mvc_demo.persistence.repositories.ProjectsRepository;
import bg.softuni._23_mvc_demo.service.projects.dtos.ProjectImportDTO;
import bg.softuni._23_mvc_demo.service.projects.dtos.ProjectXmlRootDTO;
import bg.softuni._23_mvc_demo.util.xml.LocalDateAdapter;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProjectsServiceImpl implements ProjectsService {
    private ProjectsRepository projectsRepository;
    private ModelMapper modelMapper;
    private CompaniesRepository companiesRepository;

    public ProjectsServiceImpl(ProjectsRepository projectsRepository, ModelMapper modelMapper, CompaniesRepository companiesRepository) {
        this.projectsRepository = projectsRepository;
        this.modelMapper = modelMapper;
        this.companiesRepository = companiesRepository;
    }

    @Override
    public void importProjects() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ProjectXmlRootDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        unmarshaller.setAdapter(new LocalDateAdapter());

        ProjectXmlRootDTO rootDTO = (ProjectXmlRootDTO) unmarshaller.unmarshal(
                new File("src/main/resources/files/xmls/projects.xml")
        );

        List<Project> projects = rootDTO.getProjects()
                .stream()
                .map(this::toEntity)
                .filter(Objects::nonNull)
                .toList();

        projectsRepository.saveAll(projects);
    }

    @Override
    public boolean isImported() {
        return this.companiesRepository.count() > 0;
    }

    private Project toEntity(ProjectImportDTO projectImportDTO) {
        Project project = modelMapper.map(projectImportDTO, Project.class);

        Optional<Company> company =
                companiesRepository.findByName(projectImportDTO.getCompany().getName());

        if (company.isEmpty()) {
            return null;
        }

        project.setCompany(company.get());

        return project;
    }
}
