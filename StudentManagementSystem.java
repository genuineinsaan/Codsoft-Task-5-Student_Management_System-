import java.util.ArrayList;
import java.util.Scanner;

// Student class to hold student details
class Student {
    private int id;
    private String name;
    private int age;
    private String grade;

    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters & Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Age: " + age + " | Grade: " + grade;
    }
}

// Main class
public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static int nextId = 1; // Auto-incrementing ID
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n====== Student Management System ======");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View All Students");
            System.out.println("5. Search Student by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> updateStudent();
                case 3 -> deleteStudent();
                case 4 -> viewAllStudents();
                case 5 -> searchStudent();
                case 6 -> {
                    System.out.println("Exiting... Thank you!");
                    return;
                }
                default -> System.out.println("❌ Invalid choice. Please try again.");
            }
        }
    }

    // Add Student
    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter student age: ");
        int age = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter student grade: ");
        String grade = sc.nextLine();

        Student newStudent = new Student(nextId++, name, age, grade);
        students.add(newStudent);
        System.out.println("✅ Student added successfully: " + newStudent);
    }

    // Update Student
    private static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("Enter new name (leave blank to keep current): ");
                String name = sc.nextLine();
                if (!name.isBlank()) s.setName(name);

                System.out.print("Enter new age (0 to keep current): ");
                int age = sc.nextInt();
                sc.nextLine();
                if (age > 0) s.setAge(age);

                System.out.print("Enter new grade (leave blank to keep current): ");
                String grade = sc.nextLine();
                if (!grade.isBlank()) s.setGrade(grade);

                System.out.println("✅ Student updated: " + s);
                return;
            }
        }
        System.out.println("❌ Student with ID " + id + " not found.");
    }

    // Delete Student
    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("🗑️ Student with ID " + id + " deleted.");
                return;
            }
        }
        System.out.println("❌ Student with ID " + id + " not found.");
    }

    // View All Students
    private static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠️ No students found.");
        } else {
            System.out.println("\n--- Student List ---");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    // Search Student
    private static void searchStudent() {
        System.out.print("Enter student ID to search: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("🔍 Found: " + s);
                return;
            }
        }
        System.out.println("❌ Student with ID " + id + " not found.");
    }
}
