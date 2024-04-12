package bg.softuni._23_mvc_demo.service.projects.dtos;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "projects")
public class ProjectXmlRootDTO {

    @XmlElement(name = "project")
    List<ProjectImportDTO> projects;

    public ProjectXmlRootDTO() {}

    public List<ProjectImportDTO> getProjects() {
        return projects;
    }
}
