package com.imaginnovate.employee.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Entity(name="EMPLOYEE_INFO")
@SequenceGenerator(name="employee_id_seq", initialValue=1000, allocationSize=100)
@Data
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_id_seq")
    private long id;

    private String firstName;
    private String lastName;
    private String emailId;
    private String phoneNumber;
    private Date doj;
    private Timestamp createdDateTime;
    private String createdBy;
    private Timestamp updatedDateTime;
    private String updatedBy;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinColumn(name = "emp_sal_id", referencedColumnName = "id")
    private EmployeeSalaryEntity empSalaryEntity;
}
