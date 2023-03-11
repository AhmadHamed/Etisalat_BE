package com.etisalat;

import static org.assertj.core.api.Assertions.assertThat;

import com.etisalat.controllers.DepartmentController;
import com.etisalat.repos.DepartmentRepo;
import com.etisalat.services.IDepartmentService;
import com.etisalat.services.validators.IDepartmentValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DepartmentUnitTests extends EtisalatProgrammingExerciseTestApplication {

  @Autowired private DepartmentController departmentController;
  @Autowired private DepartmentRepo departmentRepo;
  @Autowired private IDepartmentService departmentService;
  @Autowired private IDepartmentValidator departmentValidator;

  @Test
  @DisplayName("Ensure that department controller is available in the bean pool")
  @Order(1)
  public void departmentControllerTest() {
    assertThat(departmentController).isNotNull();
  }

  @Test
  @DisplayName("Ensure that department repo is available in the bean pool")
  @Order(2)
  public void departmentRepoTest() {
    assertThat(departmentRepo).isNotNull();
  }

  @Test
  @DisplayName("Ensure that department service is available in the bean pool")
  @Order(3)
  public void departmentServiceTest() {
    assertThat(departmentService).isNotNull();
  }

  @Test
  @DisplayName("Ensure that department validator is available in the bean pool")
  @Order(4)
  public void departmentValidatorTest() {
    assertThat(departmentValidator).isNotNull();
  }
}
