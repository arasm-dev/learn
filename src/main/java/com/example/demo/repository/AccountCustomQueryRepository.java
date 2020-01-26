package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
public class AccountCustomQueryRepository {

    @Autowired
    DatabaseClient databaseClient;


    public Mono<Account> getCustomerAccount(Long customerId){


        return this.databaseClient.execute(QueryTemplate.customerAccount(customerId)).as(Account.class).fetch().first();
    }

    public Flux<AccountsView> getCustomerAccountsView(Long customerId){


        return this.databaseClient.execute(QueryTemplate.accountsViewQuery(customerId)).as(AccountsView.class).fetch().all();


    }

    public Flux<AccountTransactionsView> getAccountsTransactionView(Long accountId){


        return this.databaseClient.execute(QueryTemplate.accountsTransactionViewQuery(accountId)).as(AccountTransactionsView.class).fetch().all();


    }

}
