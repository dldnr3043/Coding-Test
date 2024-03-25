import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();

        String[] split = input.split(" ");
        List<Integer> list = new ArrayList<>();

        Arrays.stream(split).forEach(s->{
            list.add(Integer.parseInt(s));
        });

        int max = Collections.max(list);

        AtomicReference<Double> sum = new AtomicReference<>((double) 0);
        list.forEach(i->{
            sum.updateAndGet(v -> new Double((double) (v + (i / (double) max * 100))));
        });

        System.out.println(sum.get() / (double)cnt);
    }
}