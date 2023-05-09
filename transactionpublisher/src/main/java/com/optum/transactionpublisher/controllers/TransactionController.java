package com.optum.transactionpublisher.controllers;

import com.optum.transactionpublisher.dtos.TransactionVO;
import com.optum.transactionpublisher.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping({"/v1.0"})
    public ResponseEntity<?> publishTransaction(@RequestBody TransactionVO transactionVO){

        if(this.transactionService.publishMessage(transactionVO)){
            return ResponseEntity.status(HttpStatus.OK).body(transactionVO);
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Transaction Not published");
    }
}
