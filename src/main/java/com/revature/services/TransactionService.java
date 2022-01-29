package com.revature.services;

import com.revature.entities.BankAccount;
import com.revature.entities.Transaction;
import com.revature.exceptions.BankAccountNotFoundException;
import com.revature.exceptions.TransactionNotFoundException;
import com.revature.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final BankAccountService bankAccountService;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, BankAccountService bankAccountService) {
        this.transactionRepository = transactionRepository;
        this.bankAccountService = bankAccountService;
    }

    public Transaction findTransactionById(Long id) throws TransactionNotFoundException {
        Optional<Transaction> transactionOptional = transactionRepository.findById(id);
        if (!transactionOptional.isPresent()) {
            throw new TransactionNotFoundException("Transaction not found with id: "+id);
        }
        return transactionOptional.get();
    }

    public List<Transaction> findAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction saveTransaction(Transaction transaction) throws BankAccountNotFoundException {
        BankAccount initiatorBankAccount = bankAccountService.findBankAccountById(transaction.getInitiatorAccount().getAccountNumber());
        transaction.setInitiatorAccount(initiatorBankAccount);
        return (Transaction) transactionRepository.save(transaction);
    }

    public Transaction editTransaction(Transaction transaction) throws TransactionNotFoundException {
        Optional<Transaction> transactionOptional = transactionRepository.findById(transaction.getId());
        if (!transactionOptional.isPresent()) {
            throw new TransactionNotFoundException("Transaction not found with id: "+transaction.getId());
        }
        return (Transaction) transactionRepository.save(transaction);
    }

    public Transaction deleteTransaction(Long id) throws TransactionNotFoundException {
        Optional<Transaction> transactionOptional = transactionRepository.findById(id);
        if (!transactionOptional.isPresent()) {
            throw new TransactionNotFoundException("Transaction not found with id: "+id);
        }
        Transaction transaction = transactionOptional.get();
        transactionRepository.deleteById(id);
        return transaction;
    }
}
