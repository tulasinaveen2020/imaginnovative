package com.imaginnovate.employee.mapper;

import com.imaginnovate.employee.dto.EmployeeDTO;
import com.imaginnovate.employee.entity.EmployeeEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeeDTOEntityMapper implements EmpMapper{
    @Override
    public EmployeeEntity dtoToEntity(EmployeeDTO empDto) {

        if(null==empDto) return null;

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(empDto.getId());
        employeeEntity.setFirstName(empDto.getFirstName());
        employeeEntity.setLastName(empDto.getLastName());
        employeeEntity.setPhoneNumber(empDto.getPhoneNumber());
        employeeEntity.setEmailId(empDto.getEmailId());
        employeeEntity.setDoj(empDto.getDoj());
        employeeEntity.setCreatedDateTime(empDto.getCreatedDateTime());
        employeeEntity.setCreatedBy(empDto.getCreatedBy());
        employeeEntity.setUpdatedDateTime(empDto.getUpdatedDateTime());
        employeeEntity.setUpdatedBy(empDto.getUpdatedBy());
        employeeEntity.setEmpSalaryEntity(empDto.getSalary());

        return employeeEntity;
    }

    @Override
    public EmployeeDTO entityToDto(EmployeeEntity empEntity) {

        if(null==empEntity) return null;

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(empEntity.getId());
        employeeDTO.setFirstName(empEntity.getFirstName());
        employeeDTO.setLastName(empEntity.getLastName());
        employeeDTO.setPhoneNumber(empEntity.getPhoneNumber());
        employeeDTO.setEmailId(empEntity.getEmailId());
        employeeDTO.setDoj(empEntity.getDoj());
        employeeDTO.setCreatedDateTime(empEntity.getCreatedDateTime());
        employeeDTO.setCreatedBy(empEntity.getCreatedBy());
        employeeDTO.setUpdatedDateTime(empEntity.getUpdatedDateTime());
        employeeDTO.setUpdatedBy(empEntity.getUpdatedBy());
        employeeDTO.setSalary(empEntity.getEmpSalaryEntity());

        return employeeDTO;
    }
}
