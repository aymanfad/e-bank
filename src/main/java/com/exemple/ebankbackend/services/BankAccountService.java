package com.exemple.ebankbackend.services;

import com.exemple.ebankbackend.entities.BankAccount;
import com.exemple.ebankbackend.entities.Customer;

import java.util.List;

public interface BankAccountService {
    Customer saveCustomer(Customer customer);
    BankAccount saveCustomer(double initialBalance, String type, Customer customer);
    List<Customer> listCustomers();
    BankAccount getBankAccount(String accountId);
    void debit(String accountId, double amount,String description);
    void credit(String accountId, double amount,String description);
    void transfer(String accountIdSource, String accountIdDestination, double amount);

}
