import java.util.Scanner;

class Student {
    int roll;
    String name;
    float grade;

    Student(int roll, String name, float grade) {
        this.roll = roll;
        this.name = name;
        this.grade = grade;
    }

    void display() {
        System.out.println("Roll: " + roll + ", Name: " + name + ", Grade: " + grade);
    }
}

public class StudentHeapSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Student " + (i + 1));
            System.out.print("Roll No: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Grade: ");
            float grade = sc.nextFloat();

            students[i] = new Student(roll, name, grade);
        }

        Student topper = students[0];
        for (int i = 1; i < n; i++) {
            if (students[i].grade > topper.grade) {
                topper = students[i];
            }
        }
        System.out.println("\nTopper (next student for internship):");
        topper.display();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].grade > students[j + 1].grade) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        System.out.println("\nStudents sorted by grade (ascending):");
        for (Student s : students) {
            s.display();
        }

        sc.close();
    }
}
