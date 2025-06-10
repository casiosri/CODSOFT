import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int subjectCount = scanner.nextInt();

        int[] marks = new int[subjectCount];
        int totalMarks = 0;

        for (int i = 0; i < subjectCount; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks. Please enter marks between 0 and 100.");
                i--; // repeat the current iteration
            } else {
                totalMarks += marks[i];
            }
        }

        double averagePercentage = (double) totalMarks / subjectCount;
        String grade;

        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("\n--- Result ---");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
