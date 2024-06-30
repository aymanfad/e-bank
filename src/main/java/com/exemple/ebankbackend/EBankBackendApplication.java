package com.exemple.ebankbackend;

import com.exemple.ebankbackend.dtos.BankAccountDTO;
import com.exemple.ebankbackend.dtos.CurrentBankAccountDTO;
import com.exemple.ebankbackend.dtos.CustomerDTO;
import com.exemple.ebankbackend.dtos.SavingBankAccountDTO;
import com.exemple.ebankbackend.entities.*;
import com.exemple.ebankbackend.enums.AccountStatus;
import com.exemple.ebankbackend.enums.OperationType;
import com.exemple.ebankbackend.exceptions.BalanceNotSufficientException;
import com.exemple.ebankbackend.exceptions.BankAccountNotFoundException;
import com.exemple.ebankbackend.exceptions.CustomerNotFoundException;
import com.exemple.ebankbackend.repositories.AccountOperationRepository;
import com.exemple.ebankbackend.repositories.BankAccountRepository;
import com.exemple.ebankbackend.repositories.CustomerRepository;
import com.exemple.ebankbackend.services.BankAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EBankBackendApplication {

    public static void main(String[] args) {

        SpringApplication.run(EBankBackendApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BankAccountService bankAccountService){
        return args -> {
            Stream.of("majda","Ayman","joe").forEach(name->{
                CustomerDTO customer = new CustomerDTO();
                customer.setName(name);
                customer.setEmail(name + "@gmail.com");
                bankAccountService.saveCustomer(customer);
            });
            bankAccountService.listCustomers().forEach(customer -> {
                try {
                    bankAccountService.saveCurrentBankAccount(Math.random()*90000,90000,
                            customer.getId());
                    bankAccountService.saveSavingBankAccount(Math.random()*120000,5.5,
                            customer.getId());

                } catch (CustomerNotFoundException e) {
                    e.printStackTrace();
                }
            });
            List<BankAccountDTO> bankAccounts = bankAccountService.bankAccountList();
            for (BankAccountDTO bankAccount : bankAccounts) {
                for (int i = 0; i < 10; i++) {
                    String accountId;
                    if (bankAccount instanceof SavingBankAccountDTO) {
                        accountId = ((SavingBankAccountDTO) bankAccount).getId();
                    }else {
                        accountId = ((CurrentBankAccountDTO) bankAccount).getId();
                    }
                    bankAccountService.credit(accountId,10000+Math.random()*120000,"Credit");
                    bankAccountService.debit(accountId, 1000+Math.random()*9000,"Debit");
                }

            }
        };
    }

}
