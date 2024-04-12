package org.xmlproccessingex.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xmlproccessingex.data.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
