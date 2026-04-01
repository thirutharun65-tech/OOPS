import java.io.*;
import java.util.*;

abstract class Employee {
    private String empId;
    private String name;
    private String department;

    public Employee(String empId, String name, String department) {
        this.empId = empId;
        this.name = name;
        this.department = department;
    }

    public abstract void calculateSalary();

    public String getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void displayDetails() {
        System.out.println("\nEmployee Details:");
        System.out.println("ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        calculateSalary();
    }
}

class FullTimeEmployee extends Employee {
    private double basicPay, hra, da;

    public FullTimeEmployee(String id, String name, String dept, double basicPay, double hra, double da) {
        super(id, name, dept);
        this.basicPay = basicPay;
        this.hra = hra;
        this.da = da;
    }

    @Override
    public void calculateSalary() {
        double salary = basicPay + hra + da;
        System.out.println("Salary: " + salary);
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String id, String name, String dept, int hoursWorked, double hourlyRate) {
        super(id, name, dept);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public void calculateSalary() {
        double salary = hoursWorked * hourlyRate;
        System.out.println("Salary: " + salary);
    }
}

public class Payroll {
    public static Employee createEmployee(Scanner s) {
        System.out.println("Enter Employee ID:");
        String id = s.nextLine();
        System.out.println("Enter Name:");
        String name = s.nextLine();
        System.out.println("Enter Department:");
        String dept = s.nextLine();
        System.out.println("Enter Employee Type (full/part):");
        String type = s.nextLine();

        if (type.equalsIgnoreCase("full")) {
            System.out.println("Enter Basic Pay:");
            double basic = s.nextDouble();
            System.out.println("Enter HRA:");
            double hra = s.nextDouble();
            System.out.println("Enter DA:");
            double da = s.nextDouble();
            s.nextLine();
            return new FullTimeEmployee(id, name, dept, basic, hra, da);
        } else {
            System.out.println("Enter Hours Worked:");
            int hours = s.nextInt();
            System.out.println("Enter Hourly Rate:");
            double rate = s.nextDouble();
            s.nextLine();
            return new PartTimeEmployee(id, name, dept, hours, rate);
        }
    }

    public static void showPayroll(Employee e) {
        e.displayDetails();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("=== Enter First Employee Details ===");
        Employee emp1 = createEmployee(s);
        System.out.println("\n=== Enter Second Employee Details ===");
        Employee emp2 = createEmployee(s);
        System.out.println("\n===== Payroll Report =====");
        showPayroll(emp1);
        showPayroll(emp2);
    }
}
