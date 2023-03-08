package com.etisalat.requestbodies;

import static com.etisalat.utils.ErrorMessages.*;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import lombok.Builder;import lombok.Getter;
import lombok.Setter;

@Builder
public class EmployeeCreateRequest {

  @Column(nullable = false)
  @Size(min = 2, message = FIRST_NAME_LESS_THAN_2)
  private String first_name;

  @Column(nullable = false)
  @Size(min = 2, message = LAST_NAME_LESS_THAN_2)
  private String last_name;

  private String email;

  @Pattern(regexp = "@\"^[0-9-]*$\"")
  private String phone_number;

  private Date hire_date;

  @Positive(message = SALARY_GREATER_THAN_0)
  private Integer salary;

  private Integer manager_id;
  private Integer department_id;
}