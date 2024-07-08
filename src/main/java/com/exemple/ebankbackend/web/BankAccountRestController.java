package com.exemple.ebankbackend.web;

import com.exemple.ebankbackend.dtos.*;
import com.exemple.ebankbackend.entities.AccountOperation;
import com.exemple.ebankbackend.entities.BankAccount;
import com.exemple.ebankbackend.exceptions.BalanceNotSufficientException;
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

@PostMapping("/accounts/debit")
public DebitDTO debit(@RequestBody DebitDTO debitDTO) throws BankAccountNotFoundException, BalanceNotSufficientException {
        this.bankAccountService.debit(debitDTO.getAcountId(),debitDTO.getAmount(),debitDTO.getDescription());
        return debitDTO;
}

    @PostMapping("/accounts/credit")
    public CreditDTO cebit(@RequestBody CreditDTO creditDTO) throws BankAccountNotFoundException {
        this.bankAccountService.credit(creditDTO.getAcountId(),creditDTO.getAmount(),creditDTO.getDescription());
        return creditDTO;
    }


    @PostMapping("/accounts/transfer")
    public void transfer(@RequestBody TransferRequestDTO transferRequestDTO) throws BankAccountNotFoundException,
            BalanceNotSufficientException {

        this.bankAccountService.transfer(transferRequestDTO.getAccountSource(),
                transferRequestDTO.getAccountDestination(),transferRequestDTO.getAmount());
    }
}
