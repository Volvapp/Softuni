package bg.softuni._23_mvc_demo.persistence.repositories;

import bg.softuni._23_mvc_demo.persistence.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Integer> {

}
