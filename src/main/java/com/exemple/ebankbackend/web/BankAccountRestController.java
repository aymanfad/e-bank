package com.exemple.ebankbackend.web;

import com.exemple.ebankbackend.dtos.BankAccountDTO;
import com.exemple.ebankbackend.entities.BankAccount;
import com.exemple.ebankbackend.exceptions.BankAccountNotFoundException;
import com.exemple.ebankbackend.services.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BankAccountRestController {
    private BankAccountService bankAccountService;
    @GetMapping("/accounts/{accountId}")
    public BankAccountDTO getBankAccount(@PathVariable String accountId) throws BankAccountNotFoundException {
        return bankAccountService.getBankAccount(accountId);
    }
@GetMapping("/accounts")
public List<BankAccountDTO> listAccounts() {
        return  bankAccountService.bankAccountList();
}
}
