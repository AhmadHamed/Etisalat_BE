package com.etisalat.services;

import com.etisalat.entities.Employee;
import com.etisalat.requestbodies.EmployeeUpdateRequest;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
  List<Employee> getPaginatedEmployees(Pageable pageable);

  Optional<Employee> getEmployeeById(Integer id);

  void deleteEmployeeById(Integer id);

  void createEmployee(@Valid Employee createRequest);

  void updateEmployee(@Valid EmployeeUpdateRequest updateRequest, Integer id);
}
