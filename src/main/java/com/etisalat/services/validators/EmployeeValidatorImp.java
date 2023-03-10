package com.etisalat.services.validators;

import static com.etisalat.utils.ErrorMessages.EMPLOYEE_SAME_AS_MANAGER;

import com.etisalat.entities.Department;
import com.etisalat.entities.Employee;
import com.etisalat.repos.DepartmentRepo;
import com.etisalat.repos.EmployeeRepo;
import com.etisalat.requestbodies.EmployeeUpdateRequest;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeValidatorImp implements IEmployeeValidator {
  private final EmployeeRepo employeeRepo;
  private final DepartmentRepo departmentRepo;

  @Override
  public void validateUpdateEmployeeRequest(EmployeeUpdateRequest updateRequest, Integer id) {
    validateManagerExists(updateRequest.getManager_id());
    validateManagerSelfLoop(updateRequest.getManager_id(), id);
    validateDepartmentExists(updateRequest.getDepartment_id());
  }

  private void validateManagerExists(Integer manager_id) {
    if (Objects.nonNull(manager_id)) {
      Optional<Employee> manager = employeeRepo.findById(manager_id);
      if (manager.isEmpty()) {
        throw new NoSuchElementException();
      }
    }
  }

  private void validateDepartmentExists(Integer department_id) {
    if (Objects.nonNull(department_id)) {
      Optional<Department> department = departmentRepo.findById(department_id);
      if (department.isEmpty()) {
        throw new NoSuchElementException();
      }
    }
  }

  private void validateManagerSelfLoop(Integer manager_id, Integer id) {
    if (Objects.equals(manager_id, id)) {
      throw new UnsupportedOperationException(EMPLOYEE_SAME_AS_MANAGER);
    }
  }
}
