package org.productshopex.data.repositories;

import org.productshopex.data.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Set;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Set<Product> findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal from, BigDecimal to);
}
