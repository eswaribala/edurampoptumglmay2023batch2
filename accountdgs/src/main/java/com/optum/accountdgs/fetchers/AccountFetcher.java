package com.optum.accountdgs.fetchers;

import com.netflix.graphql.dgs.*;
import com.optum.accountdgs.domains.Account;
import com.optum.accountdgs.domains.AccountInput;
import com.optum.accountdgs.domains.Transaction;
import com.optum.accountdgs.domains.TransactionInput;
import com.optum.accountdgs.repositories.AccountRepository;
import com.optum.accountdgs.repositories.TransactionRepository;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class AccountFetcher {
   @Autowired
    private AccountRepository accountRepository;
   @Autowired
    private TransactionRepository transactionRepository;


    @DgsQuery
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public List<Account> allAccounts(){
         return accountRepository.findAll();
    }

    @DgsData(parentType = "Account",field = "transactionList")
    public List<Transaction> transactionList(DataFetchingEnvironment dataFetchingEnvironment){

       Account account=dataFetchingEnvironment.getSource();
       List<Transaction> transactionList=new ArrayList<Transaction>();

       for(Transaction transaction : account.getTransactionList()){
        transactionList.add(transactionRepository.findById(transaction.getTransactionId()).orElse(null));

       }
       return transactionList;

    }

    @DgsQuery
    public Account accountByAccountNo(@InputArgument("accountNo") Integer accountNo){

       return accountRepository.findById(accountNo).orElse(null);

    }

    @DgsMutation
    public Account addAccount(@InputArgument("accountInput") AccountInput accountInput){
           Account account=Account.builder()
                   .accountNo(accountInput.getAccountNo())
                   .openingDate(LocalDate.parse(accountInput.getOpeningDate()))
                   .runningTotal(accountInput.getRunningTotal())
                   .build();
          Account accountResponse= accountRepository.save(account);
       // if(accountInput.getTransactionInputList()!=null) {
            if (accountInput.getTransactionInputList().size() > 0) {
                for (TransactionInput transactionInput : accountInput.getTransactionInputList()) {
                    Transaction transaction = Transaction.builder()
                            .transactionId(transactionInput.getTransactionId())
                            .transactionDate(LocalDate.parse(transactionInput.getTransactionDate()))
                            .amount(transactionInput.getAmount())
                            .account(account).build();
                    transactionRepository.save(transaction);
                }
            }
      //  }
          accountResponse.setTransactionList(mapAccountTransactions(accountInput.getTransactionInputList()));
          return accountResponse;
    }

 private List<Transaction> mapAccountTransactions(List<TransactionInput> transactionInput) {
  List<Transaction> transactionsList = transactionInput.stream().map(tranInput -> {
   Transaction transaction = Transaction.builder()
           .transactionId(tranInput.getTransactionId())
           .amount(tranInput.getAmount())
           .transactionDate(LocalDate.parse(tranInput.getTransactionDate()))
           .build();
   return transaction;
  }).collect(Collectors.toList());
  return transactionsList;
 }

}
