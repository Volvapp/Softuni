package bg.softuni._23_mvc_demo.persistence.repositories;

import bg.softuni._23_mvc_demo.persistence.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectsRepository extends JpaRepository<Project, Integer> {
    Optional<Project> findByName(String name);
}
