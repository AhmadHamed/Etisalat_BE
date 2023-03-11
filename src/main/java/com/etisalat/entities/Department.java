package com.etisalat.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@Table(name = "departments")
@ToString
public class Department {
  @Id
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "department_id_sequence_generator")
  @SequenceGenerator(
      name = "department_id_sequence_generator",
      sequenceName = "department_id_sequence",
      allocationSize = 1)
  @Column(name = "department_id")
  private Integer id;

  @NotBlank @Column String department_name;
  @NotNull @Column private Integer manager_id;
}
