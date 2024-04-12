package org.springintro.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springintro.data.entities.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
