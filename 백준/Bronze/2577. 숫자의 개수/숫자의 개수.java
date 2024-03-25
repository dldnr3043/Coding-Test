import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        Map<String, Integer> map = new HashMap<>();

        set.forEach(s->{
            map.put(s, 0);
        });

        int[] input = new int[3];

        for(int i=0;i<input.length;i++) {
            input[i] = sc.nextInt();
        }

        String[] split = Integer.toString(input[0] * input[1] * input[2]).split("");

        Arrays.stream(split).forEach(s->{
            map.put(s, map.get(s) + 1);
        });

        set.stream().forEach(s->{
            System.out.println(map.get(s));
        });
    }
}