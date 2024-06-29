package com.exemple.ebankbackend.repositories;

import com.exemple.ebankbackend.entities.BankAccount;
import com.exemple.ebankbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

}
