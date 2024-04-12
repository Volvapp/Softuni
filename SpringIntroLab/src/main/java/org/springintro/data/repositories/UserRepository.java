package org.springintro.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springintro.data.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
