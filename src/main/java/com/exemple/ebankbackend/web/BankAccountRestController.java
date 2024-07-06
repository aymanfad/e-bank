package com.exemple.ebankbackend.web;

import com.exemple.ebankbackend.dtos.AccountHistoryDTO;
import com.exemple.ebankbackend.dtos.AccountOperationDTO;
import com.exemple.ebankbackend.dtos.BankAccountDTO;
import com.exemple.ebankbackend.entities.AccountOperation;
import com.exemple.ebankbackend.entities.BankAccount;
import com.exemple.ebankbackend.exceptions.BankAccountNotFoundException;
import com.exemple.ebankbackend.services.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
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
@GetMapping("/accounts/{accountId}/pageOperations")
public AccountHistoryDTO getAccountHistory(@PathVariable String accountId,
                                           @RequestParam(name = "page", defaultValue = "0") int page,
                                           @RequestParam(name = "size",defaultValue = "5") int size) throws BankAccountNotFoundException {
        return bankAccountService.getAccountHistory(accountId,page,size);
}
}
