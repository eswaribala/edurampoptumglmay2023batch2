package com.optum.customerglapi.queries;

//import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.optum.customerglapi.domains.CurrentAccount;
import com.optum.customerglapi.repositories.CurrentAccountRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CurrentAccountQuery implements GraphQLQueryResolver {
    @Autowired
    private CurrentAccountRepository currentAccountRepository;

    public List<CurrentAccount> findAllCurrentAccounts(){
        return this.currentAccountRepository.findAll();
    }
    public CurrentAccount findCurrentAccountById(long accountNo){
        return this.currentAccountRepository.findById(accountNo).orElse(null);
    }
    public List<CurrentAccount> findCurrentAccountByOD(long od){
        return this.currentAccountRepository.findByOD(od);
    }

}
