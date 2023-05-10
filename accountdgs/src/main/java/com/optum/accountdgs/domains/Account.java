package com.optum.accountdgs.domains;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Account_No")
    private long accountNo;
    @Column(name="Running_Total")
    private long runningTotal;
    @Column(name="OpeniingDate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate openingDate;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "account")
    private List<Transaction> transactionList;
}
