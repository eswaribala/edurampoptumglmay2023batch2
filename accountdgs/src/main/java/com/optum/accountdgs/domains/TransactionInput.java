package com.optum.accountdgs.domains;

import com.optum.accountdgs.domains.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionInput {

    private int transactionId;
    private long amount;
    private String transactionDate;
    private AccountInput account;
}
