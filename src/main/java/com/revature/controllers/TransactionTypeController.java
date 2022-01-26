package com.revature.controllers;

import com.revature.entities.TransactionType;
import com.revature.exceptions.TransactionTypeNotFoundException;
import com.revature.services.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactionType")
public class TransactionTypeController {

    private final TransactionTypeService transactionTypeService;

    @Autowired
    TransactionTypeController(TransactionTypeService transactionTypeService) {
        this.transactionTypeService = transactionTypeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionType> getTransactionTypeById(@PathVariable Long id) throws TransactionTypeNotFoundException {
        return new ResponseEntity<TransactionType>(transactionTypeService.findTransactionTypeById(id), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<TransactionType>> getAllTransactionTypes() {
        return new ResponseEntity<List<TransactionType>>(transactionTypeService.findAllTransactionTypes(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<TransactionType> addTransactionType(@RequestBody TransactionType transactionType) {
        return new ResponseEntity<TransactionType>(transactionTypeService.saveTransactionType(transactionType), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<TransactionType> editTransactionType(@RequestBody TransactionType transactionType) {
        return new ResponseEntity<TransactionType>(transactionTypeService.editTransactionType(transactionType), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TransactionType> deleteTransactionType(@PathVariable Long id) {
        return new ResponseEntity<TransactionType>(transactionTypeService.deleteTransactionType(id), HttpStatus.OK);
    }
}
