package com.etisalat.entities;

import static com.etisalat.utils.ErrorMessages.*;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@Table(name = "employees")
@ToString
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_sequence_generator")
  @SequenceGenerator(
      name = "employee_id_sequence_generator",
      sequenceName = "employee_id_sequence",
      allocationSize = 1)
  @Column(name = "employee_id")
  private Integer id;

  @Column
  @NotNull
  @Size(min = 2, message = FIRST_NAME_LESS_THAN_2)
  private String first_name;

  @Column
  @NotNull
  @Size(min = 2, message = LAST_NAME_LESS_THAN_2)
  private String last_name;

  @Column private String email;

  @Column
  @Pattern(regexp = "^([0-9]+-)*[0-9]+$")
  private String phone_number;

  @Column private Date hire_date;

  @Column
  @Positive(message = SALARY_GREATER_THAN_0)
  private Integer salary;

  @Column private Integer manager_id;
  @Column private Integer department_id;
}
