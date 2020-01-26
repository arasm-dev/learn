package com.example.demo.repository;

import lombok.*;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountsView {

    @Column("accountNo")
    private Long accountNo;

    @Column("accountName")
    private String accountName;

    @Column("accountType")
    private String accountType;

    @Column("balanceDate")
    private Date balanceDate;

    @Column("currency")
    private String currency;

    @Column("openingBalance")
    private Double openingBalance;




}
