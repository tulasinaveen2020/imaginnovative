package com.imaginnovate.employee.service;

import com.imaginnovate.employee.dto.EmployeeDTO;
import com.imaginnovate.employee.entity.EmployeeEntity;

import java.util.List;

public interface IEmployeeService {

    EmployeeEntity save(EmployeeDTO employeeDTO);
   List<EmployeeDTO> findAll();
   EmployeeDTO findById(Long empId);
   EmployeeDTO updateById(Long empId, EmployeeDTO employeeDTO);
   String deleteById(long empId);
}
