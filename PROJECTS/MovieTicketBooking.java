import java.io.*;
import java.util.*;

class Customer {
    String name;
    String phone;

    Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String toString() {
        return name + " (" + phone + ")";
    }
}

class Show {
    String movie;
    int seats;
    Map<Integer, Customer> booked = new HashMap<>();

    Show(String movie, int seats) {
        this.movie = movie;
        this.seats = seats;
    }

    void book(int seat, Customer c) {
        if (seat < 1 || seat > seats) {
            System.out.println("Invalid seat!");
        } else if (booked.containsKey(seat)) {
            System.out.println("Seat already booked!");
        } else {
            booked.put(seat, c);
            System.out.println("Booked seat " + seat + " for " + c);
        }
    }

    void showSeats() {
        System.out.print("Available seats: ");
        for (int i = 1; i <= seats; i++) {
            if (!booked.containsKey(i))
                System.out.print(i + " ");
        }
        System.out.println();
    }

    void showBookings() {
        System.out.println("Bookings for " + movie + ":");
        if (booked.isEmpty()) {
            System.out.println("No bookings yet.");
        } else {
            for (Map.Entry<Integer, Customer> e : booked.entrySet()) {
                System.out.println("Seat " + e.getKey() + " -> " + e.getValue());
            }
        }
    }
}

public class MovieTicketBooking {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Show show = new Show("Avengers", 10);

        while (true) {
            System.out.println("\nCommands: book | seats | bookings | exit");
            String cmd = s.next().toLowerCase();

            if (cmd.equals("book")) {
                System.out.print("Name: ");
                String name = s.next();
                System.out.print("Phone: ");
                String phone = s.next();
                System.out.print("Seat no: ");
                int seat = s.nextInt();
                show.book(seat, new Customer(name, phone));
            } else if (cmd.equals("seats")) {
                show.showSeats();
            } else if (cmd.equals("bookings")) {
                show.showBookings();
            } else if (cmd.equals("exit")) {
                break;
            } else {
                System.out.println("Unknown command!");
            }
        }
    }
}
