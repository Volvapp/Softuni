package org.productshopex.data.repositories;

import org.productshopex.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {

    Set<User> findAllBySoldBuyerIsNotNull();
}
