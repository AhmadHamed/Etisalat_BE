package com.etisalat.controllers;

import com.etisalat.entities.Department;
import com.etisalat.requestbodies.DepartmentUpdateRequest;
import com.etisalat.services.IDepartmentService;
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
@RequestMapping("/department")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class DepartmentController {

  private final IDepartmentService departmentService;

  /**
   * @return Http 201 Created
   */
  @PostMapping
  public ResponseEntity.BodyBuilder createDepartment(@Valid @RequestBody Department createRequest) {
    departmentService.createDepartment(createRequest);
    return ResponseEntity.status(HttpStatus.CREATED);
  }
  /**
   * @return newly created Employee
   */
  @PatchMapping(path = "/{id}")
  public ResponseEntity.BodyBuilder updateEmployee(
      @Valid @RequestBody DepartmentUpdateRequest updateRequest, @PathVariable Integer id) {
    departmentService.updateDepartment(updateRequest, id);
    return ResponseEntity.status(HttpStatus.OK);
  }
  /**
   * @return single Department
   */
  @GetMapping(path = "/{id}")
  public ResponseEntity<Department> getDepartment(@PathVariable Integer id) {
    Optional<Department> department = departmentService.getDepartmentById(id);
    return ResponseEntity.of(department);
  }
  /**
   * @param pageable [page, size, sort, direction]
   * @return paginated departments response
   */
  @GetMapping
  public ResponseEntity<List<Department>> getPaginatedDepartments(
      @PageableDefault Pageable pageable) {
    List<Department> paginatedDepartments = departmentService.getPaginatedDepartments(pageable);
    return ResponseEntity.ok(paginatedDepartments);
  }
}
