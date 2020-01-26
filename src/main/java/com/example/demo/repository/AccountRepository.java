package com.example.demo.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface AccountRepository extends ReactiveCrudRepository<Account, Long> {

    @Query("SELECT * FROM ACCOUNT WHERE CUSTOMER_ID = $1")
    Flux<Account> findByCustomer_id(Long customerId);
}
