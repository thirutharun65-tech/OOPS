import java.util.*;

class Student {
    String tenthGrade, twelveGrade, group;
    int tenthMarks, twelveMarks;
    String percentage10th, percentage12th;

    Student(String a, String b, String c, int d, int e, String f, String g) {
        tenthGrade = a;
        twelveGrade = b;
        group = c;
        tenthMarks = d;
        twelveMarks = e;
        percentage10th = f;
        percentage12th = g;
    }

    void display() {
        System.out.println("\n--- Student Info ---");
        System.out.println("10th Grade: " + tenthGrade);
        System.out.println("12th Grade: " + twelveGrade);
        System.out.println("Group: " + group);
        System.out.println("10th Marks: " + tenthMarks);
        System.out.println("12th Marks: " + twelveMarks);
        System.out.println("Percentage in 10th: " + percentage10th);
        System.out.println("Percentage in 12th: " + percentage12th);
    }

}

    class{

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = s.nextInt();
        s.nextLine();
        Student[] S = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            System.out.print("10th Grade: ");
            String a = s.nextLine();
            System.out.print("12th Grade: ");
            String b = s.nextLine();
            System.out.print("Group: ");
            String c = s.nextLine();
            System.out.print("10th Marks: ");
            int d = s.nextInt();
            System.out.print("12th Marks: ");
            int e = s.nextInt();
            s.nextLine();
            System.out.print("Percentage in 10th: ");
            String f = s.nextLine();
            System.out.print("Percentage in 12th: ");
            String g = s.nextLine();

            S[i] = new Student(a, b, c, d, e, f, g);
        }

        System.out.println("\n=== Student Records ===");
        for (Student st : S)
            st.display();
    }
}
