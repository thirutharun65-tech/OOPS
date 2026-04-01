import java.io.*;
import java.util.*;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String accountType;

    public void setAccountNumber(String a) {
        this.accountNumber = a;
    }
    public void setAccountHolderName(String b) {
        this.accountHolderName = b;
    }
    public void setBalance(double c) {
        this.balance = c;
    }
    public void setAccountType(String d) {
        this.accountType = d;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public double getBalance() {
        return balance;
    }
    public String getAccountType() {
        return accountType;
    }
    public void deposit(double amnt) {
        if (amnt <= 0) {
            System.out.println("Invalid Transaction");
        } else {
            balance += amnt;
            System.out.printf("Deposit Successful. Updated Balance: %.1f\n", balance);
        }
    }
    public void withdraw(double amount) {
        if (amount <= 0 || balance < amount) {
            System.out.println("Invalid Transaction");
        } else {
            balance -= amount;
            System.out.printf("Withdrawal Successful. Updated Balance: %.1f\n", balance);
        }
    }
    public void displayAccountDetails() {
        System.out.println("Account Details:");
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Account Holder Name: " + getAccountHolderName());
        System.out.println("Account Type: " + getAccountType());
        System.out.printf("Balance: %.1f\n", getBalance());
    }
}
public class Bank {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the account number:");
        String a = s.nextLine();
        System.out.println("Enter the account holder's name:");
        String b = s.nextLine();
        System.out.println("Enter the initial balance:");
        double c = s.nextDouble();
        s.nextLine();
        System.out.println("Enter the account type:");
        String d = s.nextLine();
        BankAccount B = new BankAccount();
        B.setAccountNumber(a);
        B.setAccountHolderName(b);
        B.setBalance(c);
        B.setAccountType(d);
        B.displayAccountDetails();
        System.out.println("Enter deposit amount:");
        double amnt = s.nextDouble();
        B.deposit(amnt);
        System.out.println("Enter withdrawal amount:");
        double amount = s.nextDouble();
        B.withdraw(amount);
        B.displayAccountDetails();
    }
}
