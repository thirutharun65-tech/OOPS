import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    double price;

    Book(String t, double p) {
        title = t;
        price = p;
    }
}

class Customer {
    String name;

    Customer(String n) {
        name = n;
    }
}

class Invoice {
    Customer customer;
    ArrayList<Book> books = new ArrayList<>();

    Invoice(Customer c) {
        customer = c;
    }

    void addBook(Book b) {
        books.add(b);
    }

    void printInvoice() {
        System.out.println("\n--- Invoice ---");
        System.out.println("Customer: " + customer.name);
        double total = 0;
        for (Book b : books) {
            System.out.println("Book: " + b.title + " | Price: ₹" + b.price);
            total += b.price;
        }
        System.out.println("Total Amount: ₹" + total);
    }
}

public class EasyLibraryInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int person = 1; person <= 4; person++) {
            System.out.println("\n=== Customer " + person + " ===");
            System.out.print("Enter customer name: ");
            String cname = sc.nextLine();
            Customer c1 = new Customer(cname);
            Invoice inv = new Invoice(c1);

            System.out.print("How many books do you want to add? ");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 1; i <= n; i++) {
                System.out.print("Enter book " + i + " title: ");
                String title = sc.nextLine();
                System.out.print("Enter book " + i + " price: ");
                double price = sc.nextDouble();
                sc.nextLine();
                inv.addBook(new Book(title, price));
            }
            inv.printInvoice();
        }
    }
}
