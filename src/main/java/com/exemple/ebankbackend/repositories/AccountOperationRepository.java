package com.exemple.ebankbackend.repositories;

import com.exemple.ebankbackend.entities.AccountOperation;
import com.exemple.ebankbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository extends JpaRepository<AccountOperation, Long> {
}
