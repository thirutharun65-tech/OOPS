import java.io.*;
import java.util.*;

class Person {
    String name;
    int age;
    String gender;

    Person(String a, int b, String c) {
        this.name = a;
        this.age = b;
        this.gender = c;
    }

    void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Gender: " + gender);
    }
}

class Patient extends Person {
    String patientId;
    String disease;
    String doctorAssigned;

    Patient(String a, int b, String c, String patientId, String disease, String doctorAssigned) {
        super(a, b, c);
        this.patientId = patientId;
        this.disease = disease;
        this.doctorAssigned = doctorAssigned;
    }

    void displayPatientInfo() {
        displayInfo();
        System.out.println("Patient ID: " + patientId + ", Disease: " + disease + ", Doctor: " + doctorAssigned);
    }
}

class Doctor extends Person {
    String doctorId;
    String specialization;

    Doctor(String name, int age, String gender, String doctorId, String specialization) {
        super(name, age, gender);
        this.doctorId = doctorId;
        this.specialization = specialization;
    }

    void displayDoctorInfo() {
        displayInfo();
        System.out.println("Doctor ID: " + doctorId + ", Specialization: " + specialization);
    }
}

class Staff extends Person {
    String staffId;
    String role;

    Staff(String a, int b, String c, String d, String e) {
        super(a, b, c);
        this.staffId = d;
        this.role = e;
    }

    void displayStaffInfo() {
        displayInfo();
        System.out.println("Staff ID: " + staffId + ", Role: " + role);
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("=== Hospital Management System ===");
        System.out.print("Enter type (Patient/Doctor/Staff): ");
        String type = s.nextLine().toLowerCase();

        if (type.equals("patient")) {
            System.out.print("Enter Patient Name: ");
            String pname = s.nextLine();
            System.out.print("Enter Age: ");
            int page = s.nextInt();
            s.nextLine();
            System.out.print("Enter Gender: ");
            String pgender = s.nextLine();
            System.out.print("Enter Patient ID: ");
            String pid = s.nextLine();
            System.out.print("Enter Disease: ");
            String disease = s.nextLine();
            System.out.print("Enter Doctor Assigned: ");
            String doctorAssigned = s.nextLine();

            Patient p = new Patient(pname, page, pgender, pid, disease, doctorAssigned);
            System.out.println("\n=== Patient Details ===");
            p.displayPatientInfo();

        } else if (type.equals("doctor")) {
            System.out.print("Enter Doctor Name: ");
            String dname = s.nextLine();
            System.out.print("Enter Age: ");
            int dage = s.nextInt();
            s.nextLine();
            System.out.print("Enter Gender: ");
            String dgender = s.nextLine();
            System.out.print("Enter Doctor ID: ");
            String did = s.nextLine();
            System.out.print("Enter Specialization: ");
            String specialization = s.nextLine();

            Doctor d = new Doctor(dname, dage, dgender, did, specialization);
            System.out.println("\n=== Doctor Details ===");
            d.displayDoctorInfo();

        } else if (type.equals("staff")) {
            System.out.print("Enter Staff Name: ");
            String sname = s.nextLine();
            System.out.print("Enter Age: ");
            int sage = s.nextInt();
            s.nextLine();
            System.out.print("Enter Gender: ");
            String sgender = s.nextLine();
            System.out.print("Enter Staff ID: ");
            String sid = s.nextLine();
            System.out.print("Enter Role: ");
            String role = s.nextLine();

            Staff staff = new Staff(sname, sage, sgender, sid, role);
            System.out.println("\n=== Staff Details ===");
            staff.displayStaffInfo();

        } else {
            System.out.println("Invalid type entered!");
        }
    }
}
