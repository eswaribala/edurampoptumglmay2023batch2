package com.optum.customerglapi.queries;

//import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.optum.customerglapi.domains.Account;
import com.optum.customerglapi.repositories.AccountRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountQueryResolver implements GraphQLQueryResolver {
  @Autowired
  private AccountRepository accountRepository;


  public Account searchByAccountNo(long accountNo){
        return this.accountRepository.findById(accountNo).orElse(null);
  }

}
