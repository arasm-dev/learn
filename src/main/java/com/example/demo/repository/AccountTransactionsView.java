package com.example.demo.repository;

import lombok.*;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountTransactionsView {

    @Column("accountNo")
    private Long accountNo;

    @Column("accountName")
    private String accountName;

    @Column("valueDate")
    private Date valueDate;

    @Column("currency")
    private String currency;

    @Column("debitAmount")
    private String debitAmount;

    @Column("creditAmount")
    private String creditAmount;

    @Column("debitOrCredit")
    private String debitOrCredit;


}
