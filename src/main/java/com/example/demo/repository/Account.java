package com.example.demo.repository;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("ACCOUNT")
public class Account {

        @Id
        @Column("ID")
        private Long id;

        @Column("CUSTOMER_ID")
        private String customerId;

        @Column("UNIQUE_NO")
        private String uniqueNo;

        @Column("NAME")
        private String name;

        @Column("TYPE")
        private Short type;

        @Column("CURRENCY")
        private Short currency;

        @Column("OPENING_BALANCE")
        private Double openingBalance;

}
