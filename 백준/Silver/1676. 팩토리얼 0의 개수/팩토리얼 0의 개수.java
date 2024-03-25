import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int answer = 0;

        answer += input / 5;
        answer += input / 25;
        answer += input / 125;

        System.out.println(answer);
    }
}