package com.revature.services;

import com.revature.entities.TransactionType;
import com.revature.exceptions.TransactionTypeNotFoundException;
import com.revature.repositories.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionTypeService {

    private final TransactionTypeRepository transactionTypeRepository;

    @Autowired
    public TransactionTypeService(TransactionTypeRepository transactionTypeRepository) {
        this.transactionTypeRepository = transactionTypeRepository;
    }

    public TransactionType findTransactionTypeById(Long id) throws TransactionTypeNotFoundException {
        Optional<TransactionType> transactionTypeOptional = transactionTypeRepository.findById(id);
        if (!transactionTypeOptional.isPresent()) {
            throw new TransactionTypeNotFoundException("TransactionType not found with id: "+id);
        }
        return transactionTypeOptional.get();
    }

    public List<TransactionType> findAllTransactionTypes() {
        return transactionTypeRepository.findAll();
    }

    public TransactionType saveTransactionType(TransactionType transactionType) {
        return (TransactionType) transactionTypeRepository.save(transactionType);
    }

    public TransactionType editTransactionType(TransactionType transactionType) {
        Optional<TransactionType> transactionTypeOptional = transactionTypeRepository.findById(transactionType.getId());
        if (!transactionTypeOptional.isPresent()) {
            new TransactionTypeNotFoundException("TransactionType not found with id: "+transactionType.getId());
        }
        return (TransactionType) transactionTypeRepository.save(transactionType);
    }

    public TransactionType deleteTransactionType(Long id) {
        Optional<TransactionType> transactionTypeOptional = transactionTypeRepository.findById(id);
        if (!transactionTypeOptional.isPresent()) {
            new TransactionTypeNotFoundException("TransactionType not found with id: "+id);
        }
        TransactionType transactionType = transactionTypeOptional.get();
        transactionTypeRepository.deleteById(id);
        return transactionType;
    }
}
