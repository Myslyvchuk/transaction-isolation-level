package com.myslyv4uk.transaction.isolation.level.dirty.read;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.myslyv4uk.transaction.isolation.level.persistence.entity.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DirtyReadTest {

  @Autowired
  private DirtyReadService dirtyReadService;

  @Autowired
  private TransactionTemplate transactionTemplate;

  @Autowired
  private DefaultTransactionDefinition defaultTransactionDefinition;

  @Test
  public void testDirtyRead_Scenario_ExpectedBehavior() {
    //Arrange
    defaultTransactionDefinition.setIsolationLevel(DefaultTransactionDefinition.ISOLATION_READ_UNCOMMITTED);
    defaultTransactionDefinition.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRES_NEW);
    final Customer sam = transactionTemplate.execute(new TransactionCallback<Customer>() {
      @Override
      public Customer doInTransaction(TransactionStatus status) {
        return dirtyReadService.getCustomerByName("Sam");
      }
    });
    //Act
    transactionTemplate.execute(new TransactionCallbackWithoutResult() {
        @Override
        protected void doInTransactionWithoutResult(TransactionStatus status) {
          dirtyReadService.setCustomerBalance(sam.getCustName(),200L);
        }
    });
    final Customer customerByName = dirtyReadService.getCustomerByName(sam.getCustName());

    //Assert
    assertThat(sam.getBalance()).isEqualTo(1000);
    assertThat(customerByName.getBalance()).isEqualTo(200);
  }

}


