package com.imaginnovate.employee.controller;

import com.imaginnovate.employee.dto.EmployeeDTO;
import com.imaginnovate.employee.dto.EmployeeTaxInfoDTO;
import com.imaginnovate.employee.service.IEmployeeService;
import com.imaginnovate.employee.util.CessAmtComputationUtil;
import com.imaginnovate.employee.util.EmployeeCurrentFYTotalSalaryCalcUtil;
import com.imaginnovate.employee.util.TaxAmtComputationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/api/innovate/emp/tax")
public class EmployeesListTaxInfoController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/info/all")
    public ResponseEntity<List<EmployeeTaxInfoDTO>> getEmployeesTaxInfoList()
    {
        List<EmployeeDTO> employeesList = employeeService.findAll();
        return new ResponseEntity<List<EmployeeTaxInfoDTO>>(convertEmployeeDTOToEmployeeTaxInfoDTO(employeesList), HttpStatus.ACCEPTED);
    }

    public static List<EmployeeTaxInfoDTO> convertEmployeeDTOToEmployeeTaxInfoDTO(List<EmployeeDTO> employeesList){

        List<EmployeeTaxInfoDTO> employeeTaxInfoDTOList = new ArrayList<>();
        EmployeeTaxInfoDTO employeeTaxInfoDTO = null;
        for(EmployeeDTO employee : employeesList){

            double empYearlySalary = EmployeeCurrentFYTotalSalaryCalcUtil
                    .calculateCurrentFinYearTotalAnnualSalary(employee.getSalary().getSalary(), employee.getDoj());
            double empSalaryTax  = TaxAmtComputationUtil.calculateTax(empYearlySalary);
            double empCessAmount = CessAmtComputationUtil.calculateCessAmtOnSalary(empYearlySalary);

            employeeTaxInfoDTO = new EmployeeTaxInfoDTO();

            employeeTaxInfoDTO.setEmpId(employee.getId());
            employeeTaxInfoDTO.setFirstName(employee.getFirstName());
            employeeTaxInfoDTO.setLastName(employee.getLastName());
            long mSalary = employee.getSalary().getSalary();
            employeeTaxInfoDTO.setYearlySalary(empYearlySalary);
            employeeTaxInfoDTO.setTaxAmt(empSalaryTax);
            employeeTaxInfoDTO.setCessAmt(empCessAmount);

            employeeTaxInfoDTOList.add(employeeTaxInfoDTO);

        }

        return employeeTaxInfoDTOList;
    }
}
