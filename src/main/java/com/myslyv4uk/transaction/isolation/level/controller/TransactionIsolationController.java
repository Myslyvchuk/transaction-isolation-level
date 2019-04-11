//package com.myslyv4uk.transaction.isolation.level.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.myslyv4uk.transaction.isolation.level.dirty.read.DirtyReadService;
//import com.myslyv4uk.transaction.isolation.level.persistence.entity.Customer;
//
//@RestController
//public class TransactionIsolationController {
//
//  private final DirtyReadService dirtyReadService;
//
//  @Autowired
//  public TransactionIsolationController(DirtyReadService dirtyReadService){
//    this.dirtyReadService = dirtyReadService;
//  }
//
//  @GetMapping(path = "/customer/{name}")
//  public Customer getDirtyReadCustomer(@PathVariable String name){
//    return dirtyReadService.getCustomerByName(name);
//  }
//
//}
