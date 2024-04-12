package bg.softuni._23_mvc_demo.persistence.repositories;

import bg.softuni._23_mvc_demo.persistence.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompaniesRepository extends JpaRepository<Company, Integer> {
    Optional<Company> findByName(String name);
}
