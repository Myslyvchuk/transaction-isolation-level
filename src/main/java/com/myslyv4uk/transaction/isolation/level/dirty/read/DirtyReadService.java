package com.myslyv4uk.transaction.isolation.level.dirty.read;

import com.myslyv4uk.transaction.isolation.level.persistence.entity.Customer;

public interface DirtyReadService {

  Customer getCustomerByName(String name);

  Long getCustomerBalanceByName(String name);

  void setCustomerBalance(String name, Long balance);

  void setCustomerName(String name, String newName);

}
