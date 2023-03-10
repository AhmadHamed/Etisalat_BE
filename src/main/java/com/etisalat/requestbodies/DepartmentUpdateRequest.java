package com.etisalat.requestbodies;

import com.etisalat.entities.Department;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DepartmentUpdateRequest {

  @NotBlank private String department_name;
  @NotNull private Integer manager_id;

  public Department getUpdatedDepartment(
      Department department, DepartmentUpdateRequest updateRequest) {
    department.setDepartment_name(updateRequest.department_name);
    department.setManager_id(updateRequest.manager_id);
    return department;
  }
}
