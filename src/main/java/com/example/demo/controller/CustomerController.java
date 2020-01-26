/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.repository.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author arasm-dev
 */
@RestController()
@RequestMapping(value = "/customers")
class CustomerController {

    private final CustomerRepository customers;

    public CustomerController(CustomerRepository customers) {
        this.customers = customers;
    }

    @GetMapping("")
    public Flux<Customer> all() {
        return this.customers.findAll();
    }

    @PostMapping("")
    public Mono<Customer> create(@RequestBody Customer customer) {
        return this.customers.save(customer);
    }

    @GetMapping("/{id}")
    public Mono<Customer> get(@PathVariable("id") Long id) {
        return this.customers.findById(id);
    }

    @PutMapping("/{id}")
    public Mono<Customer> update(@PathVariable("id") Long id, @RequestBody Customer customer) {
        return this.customers.findById(id)
            .map(p -> {
                p.setFirstName(customer.getFirstName());
                p.setLastName(customer.getLastName());
                p.setEmail(customer.getEmail());
                p.setPassword(customer.getPassword());
                return p;
            })
            .flatMap(p -> this.customers.save(p));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Long id) {
        return this.customers.deleteById(id);
    }

}