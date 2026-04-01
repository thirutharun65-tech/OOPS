import java.io.*;
import java.util.*;

interface Vehicle {
    void start();

    void stop();

    void fuelType();
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car starts with a key ignition.");
    }

    @Override
    public void stop() {
        System.out.println("Car stops using hydraulic brakes.");
    }

    @Override
    public void fuelType() {
        System.out.println("Car uses petrol or diesel.");
    }
}

class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike starts with a kick or self-start.");
    }

    @Override
    public void stop() {
        System.out.println("Bike stops using disc/drum brakes.");
    }

    @Override
    public void fuelType() {
        System.out.println("Bike uses petrol.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Choose a vehicle:");
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.print("Enter your choice: ");
        int choice = s.nextInt();
        Vehicle vehicle = null;
        if (choice == 1) {
            vehicle = new Car();
            System.out.println("\nCar Details:");
        } else if (choice == 2) {
            vehicle = new Bike();
            System.out.println("\nBike Details:");
        } else {
            System.out.println("Invalid choice!");
        }
        if (vehicle != null) {
            vehicle.start();
            vehicle.stop();
            vehicle.fuelType();
        }
    }
}
