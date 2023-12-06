package com.imaginnovate.employee.constant;

public  class MessageConstants {

    public static final String FIRSTNAME_VALIDATION_REQ_MSG = "The firstName is required.";
    public static final String FIRSTNAME_VALIDATION_LEN_MSG = "Firstname must be of 6 to 12 length with no special characters and digits.";
    public static final String FIRSTNAME_PATTERN = "^[a-zA-Z]{6,12}$";
    public static final String LASTNAME_VALIDATION_REQ_MSG = "The lastName is required.";
    public static final String LASTNAME_VALIDATION_LEN_MSG = " Lastname must be of 6 to 12 length with no special characters and digits.";
    public static final String LASTNAME_PATTERN = "^[a-zA-Z]{6,12}$";
    public static final String EMAIL_REQ_MSG = " The emailId is required.";
    public static final String PHONE_REQ_MSG = " Please enter valid phone number.";
    public static final String PHONE_PATTERN = " (^$|[0-9]{10})";
    public static final String PHONE_REQ_LEN_MSG = " Please enter valid phone number should contain 10 digits";
    public static final String DOJ_VALIDATION_MSG = " Please enter valid past or present date of joining in the format yyyy-MM-dd";

}
