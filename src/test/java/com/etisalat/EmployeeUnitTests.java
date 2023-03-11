package com.etisalat;

import static org.assertj.core.api.Assertions.assertThat;

import com.etisalat.controllers.EmployeeController;
import com.etisalat.repos.EmployeeRepo;
import com.etisalat.services.IEmployeeService;
import com.etisalat.services.validators.IEmployeeValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeUnitTests extends EtisalatProgrammingExerciseTestApplication {

  @Autowired private EmployeeController employeeController;
  @Autowired private EmployeeRepo employeeRepo;
  @Autowired private IEmployeeService employeeService;
  @Autowired private IEmployeeValidator employeeValidator;

  @Test
  @DisplayName("Ensure that employee controller is available in the bean pool")
  @Order(1)
  public void employeeControllerTest() {
    assertThat(employeeController).isNotNull();
  }

  @Test
  @DisplayName("Ensure that employee repo is available in the bean pool")
  @Order(2)
  public void employeeRepoTest() {
    assertThat(employeeRepo).isNotNull();
  }

  @Test
  @DisplayName("Ensure that employee service is available in the bean pool")
  @Order(3)
  public void employeeServiceTest() {
    assertThat(employeeService).isNotNull();
  }

  @Test
  @DisplayName("Ensure that employee validator is available in the bean pool")
  @Order(4)
  public void employeeValidatorTest() {
    assertThat(employeeValidator).isNotNull();
  }
}
