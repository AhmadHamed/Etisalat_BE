package com.etisalat.services;

import com.etisalat.entities.Employee;
import java.util.List;
import java.util.Optional;
import com.etisalat.requestbodies.EmployeeCreateRequest;import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
  List<Employee> getPaginatedEmployees(Pageable pageable);

  Optional<Employee> getEmployeeById(Integer id);

  void deleteEmployeeById(Integer id);
void createEmployee(EmployeeCreateRequest createRequest);}
