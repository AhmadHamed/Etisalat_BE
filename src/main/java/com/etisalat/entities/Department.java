package com.etisalat.entities;

import javax.persistence.*;
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

  @Column String department_name;
  @Column private Integer manager_id;
}
