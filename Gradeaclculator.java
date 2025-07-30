import java.util.Scanner;

public class Gradeaclculator{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask for number of subjects
        System.out.print(" Enter the number of subjects: ");
        int numSubjects = sc.nextInt();

        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        // Input marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            while (true) {
                System.out.print("Enter marks for Subject " + (i + 1) + " (0-100): ");
                int input = sc.nextInt();

                if (input >= 0 && input <= 100) {
                    marks[i] = input;
                    totalMarks += input;
                    break;
                } else {
                    System.out.println("Invalid marks! Please enter a value between 0 and 100.");
                }
            }
        }

        // Calculate average percentage
        double average = (double) totalMarks / numSubjects;

        // Determine grade
        String grade;
        if (average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 50) {
            grade = "D";
        } else {
            grade = "F (Fail)";
        }

        // Display results
        System.out.println("\n Results:");
        System.out.println("Total Marks: " + totalMarks + "/" + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", average);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}

