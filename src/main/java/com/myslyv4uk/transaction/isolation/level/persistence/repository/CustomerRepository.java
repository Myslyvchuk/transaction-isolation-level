package com.myslyv4uk.transaction.isolation.level.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myslyv4uk.transaction.isolation.level.persistence.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

  Customer findByCustNameIgnoreCase(String name);

  Long findBalanceByCustName(String name);
}
