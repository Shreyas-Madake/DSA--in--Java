package Assignments;

import java.util.Scanner;

public class Bank_Account_System {
    private String accountNumber;
    private String accountHolderName;
    private double balance;


    public Bank_Account_System(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;

        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Warning: Initial balance cannot be negative. Setting balance to 0.0.");
            this.balance = 0.0;
        }
        System.out.println("-> Parameterized Constructor (With Initial Balance) Called.");
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " to Account: " + accountNumber);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from Account: " + accountNumber);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount for Account: " + accountNumber);
        }
    }

    public void displayAccountInfo() {
        System.out.println();
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Current Balance: $" + balance);
        System.out.println("\n");
    }

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println(" Bank Account System Demo ");






            System.out.print("Enter Account Number: ");
            String accNum2 = sc.nextLine();

            System.out.print("Enter Account Holder Name: ");
            String name2 = sc.nextLine();

            // Object created using 2-parameter constructor driven by user input
            Bank_Account_System acc2 = new Bank_Account_System(accNum2, name2, 0.0);
            acc2.displayAccountInfo();





        }
    }
}