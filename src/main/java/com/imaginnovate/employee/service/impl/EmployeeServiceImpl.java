package com.imaginnovate.employee.service.impl;

import com.imaginnovate.employee.constant.ExceptionConstants;
import com.imaginnovate.employee.dto.EmployeeDTO;
import com.imaginnovate.employee.entity.EmployeeEntity;
import com.imaginnovate.employee.entity.EmployeeSalaryEntity;
import com.imaginnovate.employee.exception.EmployeeNotFoundException;
import com.imaginnovate.employee.mapper.EmpMapper;
import com.imaginnovate.employee.repository.EmpRepository;
import com.imaginnovate.employee.repository.EmpSalaryRepository;
import com.imaginnovate.employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpRepository empRepository;

    @Autowired
    private EmpSalaryRepository empSalaryRepository;
    @Override
    public EmployeeEntity save(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = empMapper.dtoToEntity(employeeDTO);
        return empRepository.save(employeeEntity);

    }

    @Override
    public List<EmployeeDTO> findAll() {
        List<EmployeeEntity> empEntityList = empRepository.findAll();
        if(empEntityList.isEmpty()) throw new EmployeeNotFoundException();

        List<EmployeeDTO> empDTOList = new ArrayList<>();
        for(EmployeeEntity empEntity : empEntityList){
            empDTOList.add(empMapper.entityToDto(empEntity));
        }
        return empDTOList;
    }

    @Override
    public EmployeeDTO findById(Long empId) {
        Optional<EmployeeEntity> empEntity = empRepository.findById(empId);
        return empMapper.entityToDto(empEntity.orElseThrow(EmployeeNotFoundException::new));
    }

    @Override
    public EmployeeDTO updateById(Long empId, EmployeeDTO employeeDTO) {
        Optional<EmployeeEntity> empEntity = empRepository.findById(empId);
        EmployeeEntity updatedEmpEntity = null;
        if(empEntity.isPresent()){
            employeeDTO.setId(empEntity.get().getId());
            updatedEmpEntity = empRepository.save(empMapper.dtoToEntity(employeeDTO));
        }
        else throw new EmployeeNotFoundException();
        return empMapper.entityToDto(updatedEmpEntity);
    }

    @Override
    public String deleteById(long empId) {
        Optional<EmployeeEntity> empEntity = empRepository.findById(empId);
        if(empEntity.isPresent()){
            empRepository.deleteById(empId);
        }
        else throw new EmployeeNotFoundException();

        return ExceptionConstants.RECORD_DELETE_MSG;
    }
}
