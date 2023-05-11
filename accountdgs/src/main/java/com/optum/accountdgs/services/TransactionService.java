package com.optum.accountdgs.services;

import com.optum.accountdgs.domains.Transaction;
import com.optum.accountdgs.exceptions.TransactionException;
import com.optum.accountdgs.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;


    public Transaction getTransactionById(int transactionId){
        Transaction transaction=this.transactionRepository.findById(transactionId).orElse(null);
        if(transaction == null)
            throw new TransactionException("Transaction not Found for the given Id"+transactionId);
        else
            return transaction;
    }


}
