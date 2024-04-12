package org.xmlproccessingex.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xmlproccessingex.data.entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
