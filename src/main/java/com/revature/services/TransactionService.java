package com.revature.services;

import com.revature.entities.BankAccount;
import com.revature.entities.Transaction;
import com.revature.exceptions.BankAccountNotFoundException;
import com.revature.exceptions.InsufficientFundsException;
import com.revature.exceptions.TransactionNotFoundException;
import com.revature.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public Transaction saveTransaction(Transaction transaction) throws BankAccountNotFoundException, InsufficientFundsException {
        BankAccount initiatorBankAccount = bankAccountService.findBankAccountById(transaction.getInitiatorAccount().getAccountNumber());
        transaction.setInitiatorAccount(initiatorBankAccount);

        if (transaction.getTransactionType().equals("WITHDRAWAL")) {
            if (initiatorBankAccount.getBalance() < transaction.getAmount()) {
                throw new InsufficientFundsException("Tried to withdraw "+transaction.getAmount()+" from account with only "+initiatorBankAccount.getBalance());
            } else {
                initiatorBankAccount.setBalance(initiatorBankAccount.getBalance()-transaction.getAmount());
                bankAccountService.editBankAccount(initiatorBankAccount);
            }
        } else if (transaction.getTransactionType().equals("DEPOSIT")) {
            initiatorBankAccount.setBalance(initiatorBankAccount.getBalance()+transaction.getAmount());
            bankAccountService.editBankAccount(initiatorBankAccount);
        }  else if (transaction.getTransactionType().equals("TRANSFER")) {
            if (initiatorBankAccount.getBalance() < transaction.getAmount()) {
                throw new InsufficientFundsException("Tried to withdraw "+transaction.getAmount()+" from account with only "+initiatorBankAccount.getBalance());
            } else {
                BankAccount recipientBankAccount = bankAccountService.findBankAccountById(transaction.getRecipientAccountNumber());
                initiatorBankAccount.setBalance(initiatorBankAccount.getBalance()-transaction.getAmount());
                recipientBankAccount.setBalance(recipientBankAccount.getBalance()+transaction.getAmount());
                bankAccountService.editBankAccount(initiatorBankAccount);
                bankAccountService.editBankAccount(recipientBankAccount);
                transactionRepository.save(transaction);
            }
        }
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

    public List<Transaction> findAllTransactionsByAccountNumber(Long accountNumber) {
        List<Transaction> transactionList = findAllTransactions();
        List<Transaction> transactionListFiltered = transactionList
            .stream()
            .filter( transaction ->
                Objects.equals(transaction.getInitiatorAccount().getAccountNumber(), accountNumber) ||
                Objects.equals(transaction.getRecipientAccountNumber(), accountNumber)
            )
            .collect(Collectors.toList());
        return transactionListFiltered;
    }

    public List<Transaction> findAllTransactionsWithinWindow(Long timestampA, Long timestampB) {
        List<Transaction> allTransactions = findAllTransactions();
        List<Transaction> allTransactionsFiltered = allTransactions
                .stream()
                .filter( transaction ->
                        transaction.getDatimeOfTransaction() > timestampA &&
                        transaction.getDatimeOfTransaction() < timestampB)
                .collect(Collectors.toList());
        return allTransactionsFiltered;
    }
}
