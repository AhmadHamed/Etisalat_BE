package com.etisalat.services.validators;

import com.etisalat.requestbodies.EmployeeUpdateRequest;

public interface IEmployeeValidator {
  void validateUpdateEmployeeRequest(EmployeeUpdateRequest updateRequest, Integer id);
}
