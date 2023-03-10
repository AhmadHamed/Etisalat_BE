package com.etisalat.services.validators;

import com.etisalat.entities.Employee;
import com.etisalat.repos.EmployeeRepo;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DepartmentValidatorImp implements IDepartmentValidator {
  private final EmployeeRepo employeeRepo;

  public void validateManagerExists(Integer manager_id) {
    if (Objects.nonNull(manager_id)) {
      Optional<Employee> manager = employeeRepo.findById(manager_id);
      if (manager.isEmpty()) {
        throw new NoSuchElementException();
      }
    }
  }
}
