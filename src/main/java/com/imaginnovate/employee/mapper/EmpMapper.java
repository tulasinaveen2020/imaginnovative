package com.imaginnovate.employee.mapper;

import com.imaginnovate.employee.dto.EmployeeDTO;
import com.imaginnovate.employee.entity.EmployeeEntity;

import java.util.Optional;

public interface EmpMapper {

    EmployeeEntity dtoToEntity(EmployeeDTO empDto);
    EmployeeDTO entityToDto (EmployeeEntity empEntity);

}
