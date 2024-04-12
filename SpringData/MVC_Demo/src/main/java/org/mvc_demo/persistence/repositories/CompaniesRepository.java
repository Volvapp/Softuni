package org.mvc_demo.persistence.repositories;

import org.mvc_demo.persistence.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompaniesRepository extends JpaRepository<Company, Integer> {
}
