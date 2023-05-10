package com.optum.accountdgs.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountInput {
    private int accountNo;
    private long runningTotal;
    private String openingDate;
    private List<TransactionInput> transactionInputList;
}
