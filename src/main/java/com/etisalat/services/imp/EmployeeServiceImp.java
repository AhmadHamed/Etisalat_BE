package com.etisalat.services.imp;

import com.etisalat.entities.Employee;
import com.etisalat.repos.EmployeeRepo;
import com.etisalat.requestbodies.EmployeeUpdateRequest;
import com.etisalat.services.IEmployeeService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import com.etisalat.services.validators.IEmployeeValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImp implements IEmployeeService {
  private final EmployeeRepo employeeRepo;
  private final IEmployeeValidator iEmployeeValidator;

  @Override
  public void createEmployee(@Valid Employee createRequest) {
    log.info("creating new employee with data: {} at: {}", createRequest, LocalDateTime.now());
    employeeRepo.save(createRequest);
  }

  @Override
  public void updateEmployee(EmployeeUpdateRequest updateRequest, Integer id) {
    log.info("Updating employee with id: {} at: {}", id, LocalDateTime.now());
    iEmployeeValidator.validateUpdateEmployeeRequest(updateRequest, id);
    Optional<Employee> employee = getEmployeeById(id);

    employee.ifPresent(
        foundEmployee -> {
          Employee updatedEmployee = updateRequest.getUpdatedEmployee(foundEmployee, updateRequest);
          employeeRepo.save(updatedEmployee);
        });
  }

  @Override
  public List<Employee> getPaginatedEmployees(Pageable pageable) {
    log.info("Getting paginated employees with pageable: {} at: {}", pageable, LocalDateTime.now());
    List<Employee> employeeList = new ArrayList<>();
    employeeRepo.findAll(pageable).forEach(employeeList::add);
    return employeeList;
  }

  @Override
  public Optional<Employee> getEmployeeById(Integer id) {
    log.info("Getting employee with id: {} at: {}", id, LocalDateTime.now());
    return employeeRepo.findById(id);
  }

  @Override
  public void deleteEmployeeById(Integer id) {
    log.info("Deleting employee with id: {} at: {}", id, LocalDateTime.now());
    employeeRepo.deleteById(id);
  }
}
