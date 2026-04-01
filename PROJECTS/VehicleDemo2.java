import java.io.*;
import java.util.*;

class Vehicle {
    String brand;
    String fuelType;

    Vehicle(String a, String b) {
        this.brand = brand;
        this.fuelType = fuelType;
    }

    void start() {
        System.out.println("Vehicle starts...");
    }

    void stop() {
        System.out.println("Vehicle stops...");
    }

    void refuel() {
        System.out.println("Refueling vehicle with " + fuelType);
    }

    void displayInfo() {
        System.out.println("Brand: " + brand + ", Fuel: " + fuelType);
    }
}

class Bike extends Vehicle {
    Bike(String a, String b) {
        super(a, b);
    }

    @Override
    void start() {
        System.out.println(brand + " Bike starts with a kick.");
    }

    @Override
    void stop() {
        System.out.println(brand + " Bike stops with hand brakes.");
    }

    @Override
    void refuel() {
        System.out.println(brand + " Bike refueled with " + fuelType + ".");
    }
}

class Car extends Vehicle {
    Car(String a, String b) {
        super(a, b);
    }

    @Override
    void start() {
        System.out.println(brand + " Car starts with a key.");
    }

    @Override
    void stop() {
        System.out.println(brand + " Car stops with hydraulic brakes.");
    }

    @Override
    void refuel() {
        System.out.println(brand + " Car refueled with " + fuelType + ".");
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Choose a vehicle: 1 for Bike, 2 for Car");
        int choice = s.nextInt();
        s.nextLine();
        System.out.print("Enter brand name: ");
        String brand = s.nextLine();
        System.out.print("Enter fuel type: ");
        String fuel = s.nextLine();
        Vehicle v = new Vehicle(brand, fuel);
        if (choice == 1) {
            v = new Bike(brand, fuel);
        } else {
            v = new Car(brand, fuel);
        }
        System.out.println("\n--- Vehicle Actions ---");
        System.out.print("Do you want to start the vehicle? (yes/no): ");
        String ans1 = s.nextLine();
        if (ans1.equalsIgnoreCase("yes")) {
            v.start();
        }
        System.out.print("Do you want to stop the vehicle? (yes/no): ");
        String ans2 = s.nextLine();
        if (ans2.equalsIgnoreCase("yes")) {
            v.stop();
        }
        System.out.print("Do you want to refuel the vehicle? (yes/no): ");
        String ans3 = s.nextLine();
        if (ans3.equalsIgnoreCase("yes")) {
            v.refuel();
        }
        System.out.print("Do you want to see vehicle info? (yes/no): ");
        String ans4 = s.nextLine();
        if (ans4.equalsIgnoreCase("yes")) {
            v.displayInfo();
        }
        System.out.println("\nProgram finished.");
    }
}
