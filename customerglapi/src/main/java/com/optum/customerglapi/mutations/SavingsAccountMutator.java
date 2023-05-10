package com.optum.customerglapi.mutations;

//import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.optum.customerglapi.domains.SavingsAccount;
import com.optum.customerglapi.domains.SavingsAccountInput;
import com.optum.customerglapi.repositories.SavingsAccountRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SavingsAccountMutator implements GraphQLMutationResolver {
    @Autowired
    private SavingsAccountRepository savingsAccountRepository;
    public SavingsAccount addSavingsAccount(SavingsAccountInput savingsAccountInput){

        SavingsAccount savingsAccount=SavingsAccount.builder()
                .accountNo(savingsAccountInput.getAccountNo())
                .openingDate(LocalDate.parse(savingsAccountInput.getOpeningDate()))
                .runningTotal(savingsAccountInput.getRunningTotal())
                .interestRate(savingsAccountInput.getInterestRate())
                .transactionType(savingsAccountInput.getTransactionType())
                .build();
          return this.savingsAccountRepository.save(savingsAccount);
    }
    public SavingsAccount updateSavingsAccount(SavingsAccountInput savingsAccountInput){
        SavingsAccount savingsAccount=SavingsAccount.builder()
                .accountNo(savingsAccountInput.getAccountNo())
                .openingDate(LocalDate.parse(savingsAccountInput.getOpeningDate()))
                .runningTotal(savingsAccountInput.getRunningTotal())
                .interestRate(savingsAccountInput.getInterestRate())
                .transactionType(savingsAccountInput.getTransactionType())
                .build();
        return this.savingsAccountRepository.save(savingsAccount);
    }
    public boolean deleteSavingsAccount(long accountNo){
        this.savingsAccountRepository.deleteById(accountNo);
        if(this.savingsAccountRepository.findById(accountNo)==null){
            return true;
        }
        else {
            return false;
        }
    }
}
