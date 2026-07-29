package Assignments;

import java.util.Scanner;

 class Student{
    private int rollNo;
    private String name;
    private String className;
    private char division;
    public void acceptInfo(Scanner scanner) {
        System.out.print("Enter Roll Number: ");
        rollNo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        name = scanner.nextLine();

        System.out.print("Enter Class: ");
        className = scanner.nextLine();

        System.out.print("Enter Division: ");
        division = scanner.next().charAt(0);
    }


    public void displayInfo() {
        System.out.print("\n" + rollNo + " " + name + " " + className + " " + division);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        System.out.println("Number of Students: ");
        int numStudents = scanner.nextInt();
        Student [] students = new Student[numStudents];// array of students
        for(int i = 0; i < numStudents; i++) {
            students[i] = new Student();
            System.out.println("Enter details  Student ");
            students[i].acceptInfo(scanner);
        }
        for(int i = 0; i < numStudents; i++) {
            students[i].displayInfo();
        }
    }

}
