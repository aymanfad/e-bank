package com.exemple.ebankbackend.dtos;

import com.exemple.ebankbackend.entities.AccountOperation;
import com.exemple.ebankbackend.entities.Customer;
import com.exemple.ebankbackend.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data

public class SavingBankAccountDTO {
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double interestRate;
}
