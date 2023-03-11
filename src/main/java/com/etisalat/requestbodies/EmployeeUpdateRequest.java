package com.etisalat.requestbodies;

import static com.etisalat.utils.ErrorMessages.*;

import com.etisalat.entities.Employee;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EmployeeUpdateRequest {

  @Email private String email;

  @Pattern(regexp = "^([0-9]+-)*[0-9]+$")
  private String phone_number;

  @Positive(message = SALARY_GREATER_THAN_0)
  private Integer salary;

  private Integer manager_id;
  private Integer department_id;

  public Employee getUpdatedEmployee(Employee employee, EmployeeUpdateRequest updateRequest) {
    employee.setEmail(updateRequest.email);
    employee.setPhone_number(updateRequest.phone_number);
    employee.setSalary(updateRequest.salary);
    employee.setManager_id(updateRequest.manager_id);
    employee.setDepartment_id(updateRequest.department_id);
    return employee;
  }
}
