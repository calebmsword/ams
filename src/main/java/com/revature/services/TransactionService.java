package com.revature.services;

import com.revature.entities.Transaction;
import com.revature.exceptions.TransactionNotFoundException;
import com.revature.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
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

    public Transaction saveTransaction(Transaction transaction) {
        return (Transaction) transactionRepository.save(transaction);
    }

    public Transaction editTransaction(Transaction transaction) {
        Optional<Transaction> transactionOptional = transactionRepository.findById(transaction.getId());
        if (!transactionOptional.isPresent()) {
            new TransactionNotFoundException("Transaction not found with id: "+transaction.getId());
        }
        return (Transaction) transactionRepository.save(transaction);
    }

    public Transaction deleteTransaction(Long id) {
        Optional<Transaction> transactionOptional = transactionRepository.findById(id);
        if (!transactionOptional.isPresent()) {
            new TransactionNotFoundException("Transaction not found with id: "+id);
        }
        Transaction transaction = transactionOptional.get();
        transactionRepository.deleteById(id);
        return transaction;
    }
}
