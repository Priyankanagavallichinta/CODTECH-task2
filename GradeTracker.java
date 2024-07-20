import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GradeTracker {
    private Map<String, Double> grades;
    private Scanner scanner;

    public GradeTracker() {
        grades = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("1. Add Grade");
            System.out.println("2. Calculate Average");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    addGrade();
                    break;
                case 2:
                    calculateAverage();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void addGrade() {
        System.out.print("Enter subject/assignment name: ");
        String name = scanner.nextLine();
        System.out.print("Enter grade (0-100): ");
        double grade = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over

        grades.put(name, grade);
        System.out.println("Grade added successfully");
    }

    private void calculateAverage() {
        if (grades.isEmpty()) {
            System.out.println("No grades added yet");
            return;
        }

        double sum = 0;
        for (double grade : grades.values()) {
            sum += grade;
        }
        double average = sum / grades.size();

        System.out.printf("Average grade: %.2f%n", average);
        System.out.println("Letter grade: " + getLetterGrade(average));
        System.out.println("GPA: " + getGPA(average));
    }

    private String getLetterGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    private String getGPA(double average) {
        if (average >= 90) {
            return "4.0";
        } else if (average >= 80) {
            return "3.0";
        } else if (average >= 70) {
            return "2.0";
        } else if (average >= 60) {
            return "1.0";
        } else {
            return "0.0";
        }
    }

    public static void main(String[] args) {
        GradeTracker gradeTracker = new GradeTracker();
        gradeTracker.run();
    }
}
