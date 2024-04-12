package bg.softuni._23_mvc_demo.service.projects;

import jakarta.xml.bind.JAXBException;

public interface ProjectsService {

    void importProjects() throws JAXBException;

    boolean isImported();
}
