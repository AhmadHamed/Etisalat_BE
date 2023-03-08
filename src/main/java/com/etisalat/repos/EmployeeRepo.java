package com.etisalat.repos;

import com.etisalat.entities.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends PagingAndSortingRepository<Employee, Integer> {}
