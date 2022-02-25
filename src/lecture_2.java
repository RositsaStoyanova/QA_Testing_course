import java.util.concurrent.ThreadLocalRandom;

public class lecture_2 {
    public static void main(String[] args) {
        int randomNum = ThreadLocalRandom.current().nextInt(-100, 100 + 1);
        if (randomNum > 0) {
            System.out.println(randomNum + " is positive.");
        } else {
            System.out.println(randomNum + " is negative.");
        }
    }
}
