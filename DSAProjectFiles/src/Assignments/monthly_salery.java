package Assignments;

import java.util.Scanner;

public class monthly_salery {
    private static int employeeCount = 0;


    private static final double TAX = 200.0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int empId = 101;
        String empName = "John Doe";
        double basicSalary = 45000.0;


        employeeCount++;


        double hra = basicSalary * 0.20;
        double da = basicSalary * 0.10;


        double grossSalary = basicSalary + hra + da;


        double providentFund = basicSalary * 0.12;
        double totalDeductions = providentFund + TAX;


        double netSalary = grossSalary - totalDeductions;
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + empName);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("HRA: " + hra);
        System.out.println("DA: " + da);
        System.out.println("Gross Salary: " + grossSalary);
        System.out.println("Provident Fund: " + providentFund);
        System.out.println("Total Deductions: " + totalDeductions);
        System.out.println("Net Salary: " + netSalary);
    }

}
