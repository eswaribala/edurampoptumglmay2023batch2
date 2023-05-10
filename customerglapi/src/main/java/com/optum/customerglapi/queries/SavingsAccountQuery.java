package com.optum.customerglapi.queries;

//import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.optum.customerglapi.domains.SavingsAccount;
import com.optum.customerglapi.exceptions.AccountNotException;
import com.optum.customerglapi.repositories.SavingsAccountRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
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
          SavingsAccount savingsAccount= this.savingsAccountRepository.findById(accountNo).orElse(null);
          if(savingsAccount==null){
              throw new AccountNotException("Account No Invalid"+accountNo);
          }
          else
          {
              return savingsAccount;
          }
   }
    public List<SavingsAccount> findSavingsAccountByROI(float roi) {

       return this.savingsAccountRepository.findByROI(roi);
    }

    public Page<SavingsAccount> findAllSavingsAccountPaged(int page, int size){
        PageRequest pageRequest=PageRequest.of(page,size);
        return this.savingsAccountRepository.findAll(pageRequest);
    }

}
