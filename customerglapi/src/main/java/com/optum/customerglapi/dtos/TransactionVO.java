package com.optum.customerglapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionVO {

    private long transactionId;
    private long amount;
    private LocalDate transactionDate;
    private long accountNo;

}
