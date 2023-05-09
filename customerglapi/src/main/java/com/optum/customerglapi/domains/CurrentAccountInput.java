package com.optum.customerglapi.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentAccountInput {
    private long accountNo;
    private long runningTotal;
    private String openingDate;
    private long overDraftLimit;
    private TransactionType transactionType;
}
