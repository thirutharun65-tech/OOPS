import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.*;

class Product {
    private String name;
    private int quantity;
    private double price;

    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product: " + name + " | Qty: " + quantity + " | Price: ₹" + price;
    }
}

class Inventory {
    private Map<String, Product> stock = new HashMap<>();

    public void addProduct(String id, Product product) {
        stock.put(id, product);
        System.out.println("Added: " + product);
    }

    public void updateQuantity(String id, int newQty) {
        if (stock.containsKey(id)) {
            stock.get(id).setQuantity(newQty);
            System.out.println("Updated quantity for " + stock.get(id).getName());
        } else {
            System.out.println("Product not found!");
        }
    }

    public void removeProduct(String id) {
        if (stock.containsKey(id)) {
            System.out.println("🗑 Removed: " + stock.get(id).getName());
            stock.remove(id);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void displayInventory() {
        if (stock.isEmpty()) {
            System.out.println("Inventory is empty!");
        } else {
            System.out.println(" Current Inventory:");
            for (Product p : stock.values()) {
                System.out.println(p);
            }
        }
    }
}

public class InventorySystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner s = new Scanner(System.in);

        System.out.println("=== Inventory System ===");
        System.out.println("Commands: add | update | remove | show | exit");

        while (true) {
            System.out.print("\nEnter command: ");
            String command = s.next().toLowerCase();

            if (command.equals("add")) {
                System.out.print("Enter Product ID: ");
                String id = s.next();
                System.out.print("Enter Name: ");
                String name = s.next();
                System.out.print("Enter Quantity: ");
                int qty = s.nextInt();
                System.out.print("Enter Price: ");
                double price = s.nextDouble();
                inventory.addProduct(id, new Product(name, qty, price));

            } else if (command.equals("update")) {
                System.out.print("Enter Product ID: ");
                String id = s.next();
                System.out.print("Enter New Quantity: ");
                int qty = s.nextInt();
                inventory.updateQuantity(id, qty);

            } else if (command.equals("remove")) {
                System.out.print("Enter Product ID: ");
                String id = s.next();
                inventory.removeProduct(id);

            } else if (command.equals("show")) {
                inventory.displayInventory();

            } else if (command.equals("exit")) {
                System.out.println("Exiting... Goodbye!");
                break;

            } else {
                System.out.println(" Unknown command! Try again.");
            }
        }
    }
}
