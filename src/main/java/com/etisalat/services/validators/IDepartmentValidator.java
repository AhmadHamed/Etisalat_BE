package com.etisalat.services.validators;

import com.etisalat.requestbodies.DepartmentUpdateRequest;

public interface IDepartmentValidator {
  void validateManagerExists(Integer manager_id);
}
