package com.myslyv4uk.transaction.isolation.level.dirty.read;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myslyv4uk.transaction.isolation.level.persistence.entity.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DirtyReadTest {

  @Autowired
  private DirtyReadService dirtyReadService;

  @Test
  public void testDirtyRead_Scenario_ExpectedBehavior() {
    //Arrange

    //Act
    final Customer sam = dirtyReadService.getCustomerByName("Sam");

    //Assert
    assertThat(sam.getBalance()).isEqualTo(1000);

  }

}


