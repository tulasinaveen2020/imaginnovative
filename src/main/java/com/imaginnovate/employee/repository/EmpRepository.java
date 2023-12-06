package com.imaginnovate.employee.repository;

import com.imaginnovate.employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmpRepository extends JpaRepository<EmployeeEntity, Long> {
}
