package com.exemple.ebankbackend.dtos;

import com.exemple.ebankbackend.enums.AccountStatus;
import lombok.Data;

import java.util.Date;

@Data

public class CurrentBankAccountDTO {
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double overDraft;
}
