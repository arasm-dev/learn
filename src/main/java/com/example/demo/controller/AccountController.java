/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.repository.*;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author arasm-dev
 */
@RestController()
@RequestMapping(value = "/accounts")
class AccountController {

    private final AccountRepository accounts;

    private final AccountCustomQueryRepository accountsCustom;

    public AccountController(AccountRepository accounts, AccountCustomQueryRepository accountsCustom) {
        this.accounts = accounts;
        this.accountsCustom = accountsCustom;
    }

    @GetMapping("")
    public Flux<Account> all() {
        return this.accounts.findAll();
    }

    @GetMapping("/customer/{customerId}")
     public Mono<Account> getCustomerAccount(@PathVariable Long customerId){
        return this.accountsCustom.getCustomerAccount(customerId);
    }

    @GetMapping("/customer/view/{customerId}")
    public Flux<AccountsView> getCustomerAccountsView(@PathVariable Long customerId){
        return this.accountsCustom.getCustomerAccountsView(customerId);
    }

    @GetMapping("/transaction/view/{accountId}")
    public Flux<AccountTransactionsView> getAccountsTransactionView(@PathVariable Long accountId){
        return this.accountsCustom.getAccountsTransactionView(accountId);
    }
    @PostMapping("")
    public Mono<Account> create(@RequestBody Account account) {
        return this.accounts.save(account);
    }

    @GetMapping("/{id}")
    public Mono<Account> get(@PathVariable("id") Long id) {
        return this.accounts.findById(id);
    }

    @PutMapping("/{id}")
    public Mono<Account> update(@PathVariable("id") Long id, @RequestBody Account account) {
        return this.accounts.findById(id)
            .map(p -> {
                p.setName(account.getName());
                p.setOpeningBalance(account.getOpeningBalance());

                return p;
            })
            .flatMap(p -> this.accounts.save(p));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Long id) {
        return this.accounts.deleteById(id);
    }

}