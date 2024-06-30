package com.exemple.ebankbackend.web;

import com.exemple.ebankbackend.entities.BankAccount;
import com.exemple.ebankbackend.services.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BankAccountRestController {
    private BankAccountService bankAccountService;

}
