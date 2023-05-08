package com.optum.customerglapi.repositories;

import com.optum.customerglapi.domains.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long> {

    @Query("Select s from SavingsAccount s where s.interestRate=:roi")
    public List<SavingsAccount> findByROI(@Param("roi") float roi);

}
