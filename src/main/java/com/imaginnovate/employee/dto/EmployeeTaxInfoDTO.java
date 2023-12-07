package com.imaginnovate.employee.dto;

import lombok.Data;

@Data
public class EmployeeTaxInfoDTO {

    public long empId;
    public String firstName;
    public String lastName;
    public double yearlySalary;
    public double taxAmt;
    public double cessAmt;

}
