package com.etisalat.services.validators;

import com.etisalat.entities.Employee;
import com.etisalat.requestbodies.EmployeeUpdateRequest;

public interface IEmployeeValidator {
  void validateUpdateEmployeeRequest(EmployeeUpdateRequest updateRequest, Integer id);

  void validateCreateEmployeeRequest(Employee createRequest);
}
