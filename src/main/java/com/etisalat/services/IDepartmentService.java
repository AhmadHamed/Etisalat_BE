package com.etisalat.services;

import com.etisalat.entities.Department;
import java.util.List;import java.util.Optional;
import org.springframework.data.domain.Pageable;

public interface IDepartmentService {
  List<Department> getPaginatedDepartments(Pageable pageable);
Optional<Department> getDepartmentById(Integer id);}
