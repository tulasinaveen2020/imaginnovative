package com.imaginnovate.employee.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TaxAmtComputationUtil {

    public static double calculateTax(double totalTaxAmtAnnualSalary){

        double totalTax = 0;

        if(totalTaxAmtAnnualSalary <= 250000){
            totalTax = 0;
        }
        else if(totalTaxAmtAnnualSalary > 250000 && totalTaxAmtAnnualSalary <= 500000){ //slab1

            double taxAmtAfterExemption = totalTaxAmtAnnualSalary - 250000;
            totalTax = taxAmtAfterExemption * 0.05;

        }
        else if(totalTaxAmtAnnualSalary > 500000 && totalTaxAmtAnnualSalary <= 1000000){ //slab1 and slab2
            double taxAmtAfterExemption = totalTaxAmtAnnualSalary - 250000;
            double slab1TaxAmt = 250000 * 0.05;
            double slab2TaxAmtAfterSlab1TaxCalculation = (taxAmtAfterExemption - 250000) * 0.1;
            totalTax = slab1TaxAmt + slab2TaxAmtAfterSlab1TaxCalculation;
        }

        else if(totalTaxAmtAnnualSalary > 1000000){ //slab1 and slab2 and slab3
            double taxAmtAfterExemption = totalTaxAmtAnnualSalary - 250000;
            double slab1TaxAmt = 250000 * 0.05;
            double slab2TaxAmt = 500000 * 0.1;
            double slab3TaxAmtAfterSlab1AndSlab2TaxCalculation = (taxAmtAfterExemption - 750000) * 0.2;
            totalTax = slab1TaxAmt + slab2TaxAmt + slab3TaxAmtAfterSlab1AndSlab2TaxCalculation;



        }
        log.info("Total Tax :" + String.valueOf(totalTax));
        return totalTax;
    }
}
