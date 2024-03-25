import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<10;i++) {
            int num = Integer.parseInt(sc.nextLine());
            set.add(num % 42);
        }

        System.out.println(set.size());
    }
}