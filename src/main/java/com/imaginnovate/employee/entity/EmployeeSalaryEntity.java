package com.imaginnovate.employee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Generated;

@Entity(name = "EMPLOYEE_SALARY_INFO")
@Data
public class EmployeeSalaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    private long salary;

}
