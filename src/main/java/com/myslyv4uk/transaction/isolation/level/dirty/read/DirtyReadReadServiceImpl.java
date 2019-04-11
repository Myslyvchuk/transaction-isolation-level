package com.myslyv4uk.transaction.isolation.level.dirty.read;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myslyv4uk.transaction.isolation.level.persistence.entity.Customer;
import com.myslyv4uk.transaction.isolation.level.persistence.repository.CustomerRepository;


@Service
@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRES_NEW)
public class DirtyReadReadServiceImpl implements DirtyReadService {

  private final CustomerRepository customerRepository;

  @Autowired
  public DirtyReadReadServiceImpl(CustomerRepository customerRepository){
    this.customerRepository = customerRepository;
  }

  @Override
  public Customer getCustomerByName(String name) {
    return customerRepository.findByCustNameIgnoreCase(name);
  }

  @Override
  public Long getCustomerBalanceByName(String name) {
    return customerRepository.findBalanceByCustName(name);
  }

  @Override
  public void setCustomerBalance(String name, Long balance) {
    final Customer customer = customerRepository.getOne(name);
    customer.setBalance(balance);
  }

  @Override
  public void setCustomerName(String name, String newName) {
    final Customer customer = customerRepository.getOne(name);
    customer.setCustName(newName);
  }
}
