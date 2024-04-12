package org.xmlproccessingex.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xmlproccessingex.data.entities.Part;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {


}
