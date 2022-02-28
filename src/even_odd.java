import java.util.Scanner;

public class even_odd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Number = Integer.parseInt(scanner.nextLine());
        if (Number%2==0){
            System.out.println("even");
        } else{
            System.out.println("odd");
        }
    }
}
