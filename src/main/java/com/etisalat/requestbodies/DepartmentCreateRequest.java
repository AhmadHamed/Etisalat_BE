package com.etisalat.requestbodies;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class DepartmentCreateRequest {

  private String department_name;
  private Integer manager_id;
}
