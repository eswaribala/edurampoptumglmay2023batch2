package com.optum.customerglapi.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Account")
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Account_No")
    private long accountNo;
    @Column(name="Running_Total")
    private long runningTotal;
    @Column(name="Opening_Date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate openingDate;

    @Enumerated(EnumType.STRING)
    @Column(name="Transaction_Type")
    private TransactionType transactionType;

}
