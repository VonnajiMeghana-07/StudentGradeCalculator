import java.util.Scanner;

public class StudentGradeCalculator {

    // Method to calculate total marks
    static int calculateTotal(int[] marks) {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total;
    }

    // Method to calculate percentage
    static double calculatePercentage(int total, int numberOfSubjects) {
        return (double) total / numberOfSubjects;
    }

    // Method to determine grade
    static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String studentName;

        // Student name validation
        while (true) {
            System.out.print("Enter student name: ");
            studentName = scanner.nextLine().trim();

            if (!studentName.isEmpty()) {
                break;
            }

            System.out.println("Name cannot be empty.");
        }

        int numberOfSubjects;

        // Subject count validation
        while (true) {
            System.out.print("Enter number of subjects: ");

            if (scanner.hasNextInt()) {
                numberOfSubjects = scanner.nextInt();

                if (numberOfSubjects > 0) {
                    break;
                }
            } else {
                scanner.next();
            }

            System.out.println("Please enter a valid number of subjects.");
        }

        int[] marks = new int[numberOfSubjects];

        // Marks input and validation
        for (int i = 0; i < numberOfSubjects; i++) {

            while (true) {
                System.out.print("Enter marks for subject " + (i + 1) + " (0-100): ");

                if (scanner.hasNextInt()) {
                    int mark = scanner.nextInt();

                    if (mark >= 0 && mark <= 100) {
                        marks[i] = mark;
                        break;
                    }
                } else {
                    scanner.next();
                }

                System.out.println("Invalid marks. Enter a value between 0 and 100.");
            }
        }

        int total = calculateTotal(marks);
        double percentage = calculatePercentage(total, numberOfSubjects);
        String grade = calculateGrade(percentage);

        System.out.println("\n===== Student Result =====");
        System.out.println("Student Name: " + studentName);
        System.out.println("Total Marks: " + total + "/" + (numberOfSubjects * 100));
        System.out.printf("Percentage: %.2f%%%n", percentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}