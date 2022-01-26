package com.revature.controllers;

import com.revature.entities.Transaction;
import com.revature.exceptions.TransactionNotFoundException;
import com.revature.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    
    private final TransactionService transactionService;

    @Autowired
    TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) throws TransactionNotFoundException {
        return new ResponseEntity<Transaction>(transactionService.findTransactionById(id), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return new ResponseEntity<List<Transaction>>(transactionService.findAllTransactions(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
        return new ResponseEntity<Transaction>(transactionService.saveTransaction(transaction), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Transaction> editTransaction(@RequestBody Transaction transaction) {
        return new ResponseEntity<Transaction>(transactionService.editTransaction(transaction), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Transaction> deleteTransaction(@PathVariable Long id) {
        return new ResponseEntity<Transaction>(transactionService.deleteTransaction(id), HttpStatus.OK);
    }
}
