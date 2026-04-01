import java.io.*;
import java.util.*;

class Person {
    String name;
    int age;

    Person(String a, int b) {
        this.name = a;
        this.age = b;
    }

    void showPersonDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Account {
    String accountNo;
    double balance;

    Account(String c, double d) {
        this.accountNo = c;
        this.balance = d;
    }

    void showAccountDetails() {
        System.out.println("Account No: " + accountNo + ", Balance: ₹" + balance);
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited ₹" + amount + ". New Balance: ₹" + balance);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew ₹" + amount + ". New Balance: ₹" + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

class EmployeeAccount extends Person {
    String empId;
    String designation;
    Account account;

    EmployeeAccount(String a, int b, String f, String e, String c, double d) {
        super(a, b);
        this.empId = f;
        this.designation = e;
        this.account = new Account(c, d);
    }

    void showEmployeeDetails() {
        System.out.println("Employee ID: " + empId + ", Designation: " + designation);
    }

    void showAllDetails() {
        System.out.println("\n--- Employee Account Details ---");
        showPersonDetails();
        showEmployeeDetails();
        account.showAccountDetails();
    }

    void deposit(double amount) {
        account.deposit(amount);
    }

    void withdraw(double amount) {
        account.withdraw(amount);
    }
}

public class EmployeeAccountDemo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = s.nextLine();

        System.out.print("Enter Age: ");
        int age = s.nextInt();
        s.nextLine();

        System.out.print("Enter Employee ID: ");
        String empId = s.nextLine();

        System.out.print("Enter Designation: ");
        String designation = s.nextLine();

        System.out.print("Enter Account No: ");
        String accountNo = s.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = s.nextDouble();

        EmployeeAccount emp = new EmployeeAccount(name, age, empId, designation, accountNo, balance);
        emp.showAllDetails();

        System.out.print("\nEnter amount to deposit: ");
        double depositAmount = s.nextDouble();
        emp.deposit(depositAmount);

        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = s.nextDouble();
        emp.withdraw(withdrawAmount);
    }
}
