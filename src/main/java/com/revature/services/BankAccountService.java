package com.revature.services;

import com.revature.entities.BankAccount;
import com.revature.exceptions.BankAccountNotFoundException;
import com.revature.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
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

    public BankAccount saveBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount editBankAccount(BankAccount bankAccount) {
        Optional<BankAccount> bankAccountOptional = bankAccountRepository.findById(bankAccount.getAccountNumber());
        if (!bankAccountOptional.isPresent()) {
            new BankAccountNotFoundException("BankAccount not found with accountNumber: "+bankAccount.getAccountNumber());
        }
        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount deleteBankAccount(Long accountNumber) throws BankAccountNotFoundException {
//        System.out.println("am i here?");
        Optional<BankAccount> bankAccountOptional = bankAccountRepository.findById(accountNumber);
//        System.out.println("bankAccountOptional is: "+bankAccountOptional.toString());
//        System.out.println("am i there?");
//        if (!bankAccountOptional.isPresent()) {
//            System.out.println("am i in the if statement?");
//            new BankAccountNotFoundException("BankAccount not found with accountNumber: "+accountNumber);
//        }
        BankAccount bankAccount = bankAccountOptional.get();
        bankAccountRepository.deleteById(accountNumber);
        return bankAccount;
    }
}
