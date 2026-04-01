import java.io.*;
import java.util.*;

class Contact<T> {
    String name;
    T phone;
    String email;

    Contact(String name, T phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String toString() {
        return name + " | " + phone + " | " + email;
    }
}

class ContactNotFoundException extends Exception {
    ContactNotFoundException(String msg) {
        super(msg);
    }
}

class ContactManager<T> {
    List<Contact<T>> list = new ArrayList<>();

    void add(Contact<T> c) {
        list.add(c);
        System.out.println("Added: " + c);
    }

    void remove(String name) throws ContactNotFoundException {
        boolean ok = list.removeIf(c -> c.name.equalsIgnoreCase(name));
        if (!ok)
            throw new ContactNotFoundException("Contact not found: " + name);
        System.out.println("Removed: " + name);
    }

    Contact<T> search(String name) throws ContactNotFoundException {
        for (Contact<T> c : list) {
            if (c.name.equalsIgnoreCase(name))
                return c;
        }
        throw new ContactNotFoundException("Contact not found: " + name);
    }

    void showAll() {
        if (list.isEmpty())
            System.out.println("No contacts.");
        else
            for (Contact<T> c : list)
                System.out.println(c);
    }
}

public class ContactManagement {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ContactManager<String> manager = new ContactManager<>();

        while (true) {
            System.out.println("\nCommands: add | remove | search | show | exit");
            String cmd = s.next().toLowerCase();

            try {
                if (cmd.equals("add")) {
                    System.out.print("Name: ");
                    String name = s.next();
                    System.out.print("Phone: ");
                    String phone = s.next();
                    System.out.print("Email: ");
                    String email = s.next();
                    manager.add(new Contact<>(name, phone, email));

                } else if (cmd.equals("remove")) {
                    System.out.print("Name: ");
                    String name = s.next();
                    manager.remove(name);

                } else if (cmd.equals("search")) {
                    System.out.print("Name: ");
                    String name = s.next();
                    System.out.println("Found: " + manager.search(name));

                } else if (cmd.equals("show")) {
                    manager.showAll();

                } else if (cmd.equals("exit")) {
                    break;

                } else {
                    System.out.println("Unknown command!");
                }
            } catch (ContactNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
