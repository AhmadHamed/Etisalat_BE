package com.etisalat.services.imp;

import com.etisalat.entities.Department;
import com.etisalat.repos.DepartmentRepo;
import com.etisalat.services.IDepartmentService;
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
public class DepartmentServiceImp implements IDepartmentService {
  private final DepartmentRepo departmentRepo;

  @Override
  public List<Department> getPaginatedDepartments(Pageable pageable) {
    log.info(
        "Getting paginated Department with pageable: {} at: {}", pageable, LocalDateTime.now());
    List<Department> departmentList = new ArrayList<>();
    departmentRepo.findAll(pageable).forEach(departmentList::add);
    return departmentList;
  }

  @Override
  public Optional<Department> getDepartmentById(Integer id) {
    log.info("Getting department with id: {} at: {}", id, LocalDateTime.now());
    return departmentRepo.findById(id);
  }
}
