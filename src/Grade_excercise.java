import java.util.Scanner;

public class Grade_excercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter grade:");
        int grade = Integer.parseInt(scanner.nextLine());
        if (grade == 2) {
            System.out.println("Poor " + grade);
        } else if (grade == 3) {
            System.out.println("Middle " + grade);
        } else if (grade == 4) {
            System.out.println("Good " + grade);
        } else if (grade == 5) {
            System.out.println("Very good " + grade);
        } else if (grade == 6) {
            System.out.println("Excellent " + grade);
        }
         else {
        System.out.println("Unknown");
        }


    }
}



