package com.etisalat.requestbodies;

import static com.etisalat.utils.ErrorMessages.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import lombok.Builder;

@Builder
public class EmployeeUpdateRequest {

  private String email;

  @Pattern(regexp = "@\"^[0-9-]*$\"")
  private String phone_number;

  @Positive(message = SALARY_GREATER_THAN_0)
  private Integer salary;

  private Integer manager_id;
  private Integer department_id;
}
