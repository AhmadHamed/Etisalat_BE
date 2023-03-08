package com.etisalat.repos;

import com.etisalat.entities.Department;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends PagingAndSortingRepository<Department, Integer> {}
