package com.optum.customerglapi.repositories;

import com.optum.customerglapi.domains.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
