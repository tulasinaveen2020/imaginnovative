package com.imaginnovate.employee.util;

public class CessAmtComputationUtil {

    public static double calculateCessAmtOnSalary(double totalSalary){
        double cessSalaryAmountToCalculate = 0.0;
        double finalCessAmt = 0.0;
        if(totalSalary > 2500000){
             cessSalaryAmountToCalculate = totalSalary - 2500000;
             finalCessAmt = cessSalaryAmountToCalculate * 0.02;

        }

        return finalCessAmt;
    }
}
