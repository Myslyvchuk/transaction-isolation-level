package com.myslyv4uk.transaction.isolation.level.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customer_info")
public class Customer {

  @Id
  @Column(name = "cust_name")
  private String custName;

  @Column(name = "balance")
  private long balance;

}
