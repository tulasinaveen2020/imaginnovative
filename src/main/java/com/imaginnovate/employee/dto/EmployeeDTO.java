package com.imaginnovate.employee.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.imaginnovate.employee.constant.MessageConstants;
import com.imaginnovate.employee.entity.EmployeeSalaryEntity;
import com.imaginnovate.employee.serialize.CustomJsonDateDeserializer;
import jakarta.annotation.Nonnull;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class EmployeeDTO {

    @JsonIgnore
    private long id;
   // private long empId;
   @NotBlank(message = MessageConstants.FIRSTNAME_VALIDATION_REQ_MSG)
   @Pattern(regexp = MessageConstants.FIRSTNAME_PATTERN,
           message = MessageConstants.FIRSTNAME_VALIDATION_LEN_MSG)
    private String firstName;
    @NotBlank(message = MessageConstants.LASTNAME_VALIDATION_REQ_MSG)
    @Pattern(regexp = MessageConstants.LASTNAME_PATTERN,
            message = MessageConstants.LASTNAME_VALIDATION_LEN_MSG)
    private String lastName;
   @NotBlank(message = MessageConstants.EMAIL_REQ_MSG)
    @Email
    private String emailId;

   @NotEmpty(message = MessageConstants.PHONE_REQ_LEN_MSG)
   // @Pattern(regexp=MessageConstants.PHONE_PATTERN,  message = MessageConstants.PHONE_REQ_LEN_MSG)
   private String phoneNumber;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    @PastOrPresent(message = MessageConstants.DOJ_VALIDATION_MSG)
    private Date doj;

    private Timestamp createdDateTime;
    private String createdBy;
    private Timestamp updatedDateTime;
    private String updatedBy;

    private EmployeeSalaryEntity salary;
}
