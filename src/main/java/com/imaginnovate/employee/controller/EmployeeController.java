package com.imaginnovate.employee.controller;

import com.imaginnovate.employee.constant.LoggerConstants;
import com.imaginnovate.employee.dto.EmployeeDTO;
import com.imaginnovate.employee.entity.EmployeeEntity;
import com.imaginnovate.employee.mapper.EmpMapper;
import com.imaginnovate.employee.service.IEmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/api/innovate/emp")
@Slf4j
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private EmpMapper empMapper;

    @PostMapping("/create")
    private ResponseEntity<EmployeeDTO> save(@Valid @RequestBody  EmployeeDTO employeeDTO){
        log.info(LoggerConstants.LOG_SAVE_START_MSG);
        EmployeeEntity persistedEmployee = employeeService.save(employeeDTO);
        return new ResponseEntity<EmployeeDTO>(empMapper.entityToDto(persistedEmployee), HttpStatus.CREATED);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<EmployeeDTO>> findEmployees(){
        log.info(LoggerConstants.LOG_FIND_ALL_MSG);
        return new ResponseEntity<List<EmployeeDTO>>(employeeService.findAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/find/{empId}")
    public ResponseEntity<EmployeeDTO> findEmployee(@PathVariable  Long empId){
        log.info(LoggerConstants.LOG_FIND_MSG);
        return new ResponseEntity<EmployeeDTO>(employeeService.findById(empId), HttpStatus.ACCEPTED);
    }
    @PutMapping("/update/{empId}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable  Long empId, @Valid @RequestBody EmployeeDTO employeeDTO){
        log.info(LoggerConstants.LOG_UPDATE_START_MSG);
        return new ResponseEntity<EmployeeDTO>(employeeService.updateById(empId, employeeDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployee(Long empId){
        log.info(LoggerConstants.LOG_DELETE_START_MSG);
        String message = employeeService.deleteById(empId);
        return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);

    }
}
