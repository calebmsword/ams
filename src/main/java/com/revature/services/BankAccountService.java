package com.revature.services;

import com.revature.entities.BankAccount;
import com.revature.entities.Customer;
import com.revature.exceptions.BankAccountNotFoundException;
import com.revature.exceptions.CustomerNotFoundException;
import com.revature.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;
    private final CustomerService customerService;

    @Autowired
    public BankAccountService(BankAccountRepository bankAccountRepository, CustomerService customerService) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerService = customerService;
    }

    public BankAccount findBankAccountById(Long accountNumber) throws BankAccountNotFoundException {
        Optional<BankAccount> bankAccountOptional = bankAccountRepository.findById(accountNumber);
        if (!bankAccountOptional.isPresent()) {
            throw new BankAccountNotFoundException("BankAccount not found with accountNumber: "+accountNumber);
        }
        return bankAccountOptional.get();
    }

    public List<BankAccount> findAllBankAccounts() {
        return bankAccountRepository.findAll();
    }

    public BankAccount saveBankAccount(BankAccount bankAccount) throws CustomerNotFoundException {
        Customer customer = customerService.findCustomerById(bankAccount.getCustomer().getPermanentAccountNumber());
        bankAccount.setCustomer(customer);
        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount editBankAccount(BankAccount bankAccount) throws BankAccountNotFoundException {
        Optional<BankAccount> bankAccountOptional = bankAccountRepository.findById(bankAccount.getAccountNumber());
        if (!bankAccountOptional.isPresent()) {
            throw new BankAccountNotFoundException("BankAccount not found with accountNumber: "+bankAccount.getAccountNumber());
        }
        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount deleteBankAccount(Long accountNumber) throws BankAccountNotFoundException {
        Optional<BankAccount> bankAccountOptional = bankAccountRepository.findById(accountNumber);
        if (!bankAccountOptional.isPresent()) {
            throw new BankAccountNotFoundException("BankAccount not found with accountNumber: "+accountNumber);
        }
        BankAccount bankAccount = bankAccountOptional.get();
        bankAccountRepository.deleteById(bankAccount.getAccountNumber());
        return bankAccount;
    }

    public List<BankAccount> findAllBankAccountsByPan(Long pan) {
        List<BankAccount> bankAccountList = findAllBankAccounts();
        List<BankAccount> bankAccountListFiltered = bankAccountList
                .stream()
                .filter( bankAccount -> Objects.equals(bankAccount.getCustomer().getPermanentAccountNumber(), pan))
                .collect(Collectors.toList());
        return bankAccountListFiltered;
    }
}
