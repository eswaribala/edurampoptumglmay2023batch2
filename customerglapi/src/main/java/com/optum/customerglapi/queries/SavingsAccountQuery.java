package com.optum.customerglapi.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.optum.customerglapi.domains.SavingsAccount;
import com.optum.customerglapi.repositories.SavingsAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SavingsAccountQuery implements GraphQLQueryResolver {

    @Autowired
    private SavingsAccountRepository savingsAccountRepository;
   public List<SavingsAccount> findAllSavingsAccount(){
          return this.savingsAccountRepository.findAll();
   }
   public SavingsAccount findSavingsAccountById(long accountNo){
           return this.savingsAccountRepository.findById(accountNo).orElse(null);
   }
    public List<SavingsAccount> findSavingsAccountByROI(float roi) {

       return this.savingsAccountRepository.findByROI(roi);
    }

    public Page<SavingsAccount> findAllSavingsAccountPaged(int page, int size){
        PageRequest pageRequest=PageRequest.of(page,size);
        return this.savingsAccountRepository.findAll(pageRequest);
    }

}
