package com.imaginnovate.employee.repository;

import com.imaginnovate.employee.entity.EmployeeSalaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmpSalaryRepository extends JpaRepository<EmployeeSalaryEntity, Integer> {
}
