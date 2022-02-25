import java.util.concurrent.ThreadLocalRandom;

public class Ternary_operator {
    public static void main(String[] args) {
        int randomNum = ThreadLocalRandom.current().nextInt(-100, 100 + 1);
        String result = (randomNum > 0) ? "Number is positive." : "Number is negative.";
        System.out.println(result);
    }
}
