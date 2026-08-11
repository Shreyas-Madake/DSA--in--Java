package Assignments;

import java.util.Scanner;

class EmployeeTest {

    private int id;
    private String name;
    private double salary;


    private static String companyName = "TechCorp Solutions";


    public EmployeeTest(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }


    public static void setCompanyName(String newCompanyName) {
        companyName = newCompanyName;
    }

    public void displayInfo() {
        System.out.println("ID: " + this.id +
                " | Name: " + this.name +
                " | Salary: $" + this.salary +
                " | Company: " + companyName);
    }
}

public class Employee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee 1 ID, Name, Salary: ");
        int id1 = sc.nextInt();
        sc.nextLine();
        String name1 = sc.nextLine();
        double salary1 = sc.nextDouble();

        System.out.print("Enter Employee 2 ID, Name, Salary: ");
        int id2 = sc.nextInt();
        sc.nextLine();
        String name2 = sc.nextLine();
        double salary2 = sc.nextDouble();

        System.out.println("\nCreating Employees...");
        EmployeeTest emp1 = new EmployeeTest(id1, name1, salary1);
        EmployeeTest emp2 = new EmployeeTest(id2, name2, salary2);


        emp1.displayInfo();
        emp2.displayInfo();

        System.out.print("\nEnter new Company Name: ");
        sc.nextLine();
        String newCompany = sc.nextLine();


        EmployeeTest.setCompanyName(newCompany);


        emp1.displayInfo();
        emp2.displayInfo();

    }
}