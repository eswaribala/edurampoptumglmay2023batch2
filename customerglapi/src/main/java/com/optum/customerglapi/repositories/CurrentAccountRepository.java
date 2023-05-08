package com.optum.customerglapi.repositories;

import com.optum.customerglapi.domains.CurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentAccountRepository extends JpaRepository<CurrentAccount,Long> {
}
