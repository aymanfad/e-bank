package com.exemple.ebankbackend.repositories;

import com.exemple.ebankbackend.entities.AccountOperation;
import com.exemple.ebankbackend.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountOperationRepository extends JpaRepository<AccountOperation, Long> {
    public List<AccountOperation> findByBankAccountId(String accountId);
    public Page<AccountOperation> findByBankAccountIdOrderByOperationDateDesc(String accountId, Pageable pageable);
}
