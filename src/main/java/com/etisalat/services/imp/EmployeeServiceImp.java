package com.etisalat.services.imp;

import com.etisalat.entities.Employee;
import com.etisalat.repos.EmployeeRepo;
import com.etisalat.requestbodies.EmployeeCreateRequest;
import com.etisalat.services.IEmployeeService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImp implements IEmployeeService {
  private final EmployeeRepo employeeRepo;

  @Override
  public void createEmployee(EmployeeCreateRequest createRequest) {

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
