package com.optum.accountdgs.repositories;

import com.optum.accountdgs.domains.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
