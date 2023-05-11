package com.optum.accountdgs.fetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.optum.accountdgs.domains.Account;
import com.optum.accountdgs.domains.Transaction;
import com.optum.accountdgs.domains.TransactionInput;
import com.optum.accountdgs.repositories.AccountRepository;
import com.optum.accountdgs.repositories.TransactionRepository;
import com.optum.accountdgs.services.TransactionService;
import graphql.schema.DataFetchingEnvironment;
import org.dataloader.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@DgsComponent
public class TransactionFetcher {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionService transactionService;

    @DgsQuery
    public List<Transaction> allTransactions(){

        return transactionRepository.findAll();
    }

    @DgsQuery
    public Transaction transactionById(int transactionId){

       return transactionService.getTransactionById(transactionId);
    }


    @DgsData(parentType = "Transaction", field = "account")
    public CompletableFuture<Account> account(DataFetchingEnvironment dataFetchingEnvironment){
        DataLoader<Integer,Account> dataLoader = dataFetchingEnvironment.getDataLoader("accounts");
        Transaction transaction = dataFetchingEnvironment.getSource();
        return dataLoader.load(transaction.getAccount().getAccountNo());

    }


    @DgsMutation
    public Transaction addTransaction(TransactionInput transactionInput){
/*
        Account account=Account.builder()
                .accountNo(transactionInput.getAccount().getAccountNo())
                 .runningTotal(transactionInput.getAccount().getRunningTotal())
                .openingDate(LocalDate.parse(transactionInput.getAccount().getOpeningDate())).build();
*/
        Account account= accountRepository.findById(transactionInput.getAccount().getAccountNo())
                .orElse(null);
        if(account!=null) {
            Transaction transaction = Transaction.builder()
                    .transactionId(transactionInput.getTransactionId())
                    .amount(transactionInput.getAmount())
                    .transactionDate(LocalDate.parse(transactionInput.getTransactionDate()))
                    .account(account).build();
            return transactionRepository.save(transaction);
        }
        else
            return null;


    }


}
