package com.etisalat.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "departments")
public class Department {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "department_id")
  private Integer id;

  @NotBlank @Column String department_name;
  @NotNull @Column private Integer manager_id;
}
