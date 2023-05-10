package com.optum.accountdgs.repositories;

import com.optum.accountdgs.domains.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
}
