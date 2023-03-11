package com.etisalat.controllers;

import com.etisalat.entities.Employee;
import com.etisalat.requestbodies.EmployeeUpdateRequest;
import com.etisalat.services.IEmployeeService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class EmployeeController {

  private final IEmployeeService employeeService;

  /**
   * @return Http 201 Created
   */
  @PostMapping
  public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee createRequest) {
    employeeService.createEmployee(createRequest);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
  /**
   * @return Http 200 OK
   */
  @PatchMapping(path = "/{id}")
  public ResponseEntity<Employee> updateEmployee(
      @Valid @RequestBody EmployeeUpdateRequest updateRequest, @PathVariable Integer id) {
    employeeService.updateEmployee(updateRequest, id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
  /**
   * @return single Employee
   */
  @GetMapping(path = "/{id}")
  public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
    Optional<Employee> employee = employeeService.getEmployeeById(id);
    return ResponseEntity.of(employee);
  }
  /**
   * @param pageable [page, size, sort, direction]
   * @return paginated Employee response
   */
  @GetMapping
  public ResponseEntity<List<Employee>> getPaginatedEmployees(@PageableDefault Pageable pageable) {
    List<Employee> paginatedEmployees = employeeService.getPaginatedEmployees(pageable);
    return ResponseEntity.ok(paginatedEmployees);
  }
  /**
   * deletes an employee by id
   *
   * @return status 204 No Content
   */
  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Employee> deleteEmployee(@PathVariable Integer id) {
    employeeService.deleteEmployeeById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
