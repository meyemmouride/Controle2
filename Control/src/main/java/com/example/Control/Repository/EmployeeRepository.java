package com.example.Control.Repository;

import all.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}