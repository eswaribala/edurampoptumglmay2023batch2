package com.optum.customerglapi.mutations;

//import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.optum.customerglapi.domains.CurrentAccount;
import com.optum.customerglapi.domains.CurrentAccountInput;
import com.optum.customerglapi.repositories.CurrentAccountRepository;
//import org.checkerframework.checker.units.qual.Current;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CurrentAccountMutator implements GraphQLMutationResolver {
    @Autowired
    private CurrentAccountRepository currentAccountRepository;

    public CurrentAccount addCurrentAccount(CurrentAccountInput currentAccountInput){
         CurrentAccount currentAccount=CurrentAccount.builder()
                 .accountNo(currentAccountInput.getAccountNo())
                 .openingDate(LocalDate.parse(currentAccountInput.getOpeningDate()))
                 .runningTotal(currentAccountInput.getRunningTotal())
                 .transactionType(currentAccountInput.getTransactionType())
                 .overDraftLimit(currentAccountInput.getOverDraftLimit()).build();
           return  this.currentAccountRepository.save(currentAccount);
    }
    public CurrentAccount updateCurrentAccount(CurrentAccountInput currentAccountInput){
        CurrentAccount currentAccount=CurrentAccount.builder()
                .accountNo(currentAccountInput.getAccountNo())
                .openingDate(LocalDate.parse(currentAccountInput.getOpeningDate()))
                .transactionType(currentAccountInput.getTransactionType())
                .runningTotal(currentAccountInput.getRunningTotal())
                .overDraftLimit(currentAccountInput.getOverDraftLimit()).build();
        return  this.currentAccountRepository.save(currentAccount);
    }
    public boolean deleteCurrentAccount(long accountNo){
        this.currentAccountRepository.deleteById(accountNo);
        if(this.currentAccountRepository.findById(accountNo)==null){
            return true;
        }
        else {
            return false;
        }
    }
}
