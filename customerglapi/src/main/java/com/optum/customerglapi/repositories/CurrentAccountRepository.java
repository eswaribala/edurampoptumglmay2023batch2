package com.optum.customerglapi.repositories;

import com.optum.customerglapi.domains.CurrentAccount;
import com.optum.customerglapi.domains.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CurrentAccountRepository extends JpaRepository<CurrentAccount,Long> {

    @Query("Select c from CurrentAccount c where c.overDraftLimit=:od")
    public List<CurrentAccount> findByOD(@Param("od")  long od);
}
