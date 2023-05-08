package com.optum.customerglapi.repositories;

import com.optum.customerglapi.domains.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long> {
}
