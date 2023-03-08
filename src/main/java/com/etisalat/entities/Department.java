package com.etisalat.entities;

import java.math.BigDecimal;
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

  private String department_name;
  private Integer manager_id;
}
