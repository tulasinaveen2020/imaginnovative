package com.imaginnovate.employee.util;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.Month;
public class EmployeeCurrentFYTotalSalaryCalcUtil {

    public static double calculateCurrentFinYearTotalAnnualSalary(long monthlySalary, Date doj){

       int totalMonthsCurrentFinYear = 12;
       int currentFinYear = LocalDateTime.now().getYear();
       int currentFinYearStartMonthValue = 4;
       int yearOfDOJ = doj.toLocalDate().getYear();
       double totalAnnualSalary = 0.0;
       int dojMonthValue = doj.toLocalDate().getMonthValue();
       int dojDate = doj.toLocalDate().getDayOfMonth();
       int totalFinYearMonths = 12;

        /** If Employee date of joining year is < current fin year
         * Calculate default for 12 months * monthly salary
         */

            if(Integer.compare(yearOfDOJ , currentFinYear) < 0)
            {
                totalAnnualSalary = monthlySalary * 12;
            }

        /** If Employee date of joining year is equal to current fin year and
         * month value is less than current fin year
         * Calculate default for 12 months * monthly salary
         */
            if(Integer.compare(yearOfDOJ , currentFinYear) == 0 &&
                Integer.compare(dojMonthValue, currentFinYearStartMonthValue) < 0){
                totalAnnualSalary = monthlySalary * 12;
        }

        /** If Employee date of joining year is equal to current fin year and
         * month value is greater than current fin year start month value
         * Calculate Current month paid salary + remaining months * monthlySalary
         */

        if(Integer.compare(yearOfDOJ , currentFinYear) == 0 &&
                Integer.compare(dojMonthValue, currentFinYearStartMonthValue) >= 0){

            int mSalary = (int) monthlySalary;

            int currentMonthLength = doj.toLocalDate().lengthOfMonth();
            int currentJoinedMonthPaidDays = currentMonthLength - (dojDate-1);
            int currentJoinedMonthDaySalary = mSalary / currentMonthLength;
            int currentJoinedMonthSalaryPaidDaysAmt = currentJoinedMonthPaidDays * currentJoinedMonthDaySalary;
            int dojMonthNextMonthValue = dojMonthValue + 1;

            int CurrentFinYeaRemMonthsSalary = (totalFinYearMonths - (dojMonthNextMonthValue - currentFinYearStartMonthValue)) * mSalary;

            totalAnnualSalary = currentJoinedMonthSalaryPaidDaysAmt + CurrentFinYeaRemMonthsSalary;

        }

        return totalAnnualSalary;
    }
}
