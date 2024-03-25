import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "";
        AtomicReference<String> ans = new AtomicReference<>("");
        AtomicInteger max = new AtomicInteger();


        str = sc.nextLine().trim().toLowerCase();

        String[] split = str.split("");

        Set<String> set = new HashSet<>(Arrays.asList(split));
        Map<String, Integer> map = new HashMap<>();

        set.forEach(s->{
            map.put(s, 0);
        });

        Arrays.stream(split).forEach(s->{
            map.put(s, map.get(s) + 1);
        });

        set.forEach(s->{
            if(max.get() < map.get(s)) {
                ans.set(s);
                max.set(map.get(s));
            }
        });

        AtomicInteger cnt = new AtomicInteger();
        set.forEach(s->{
            if(map.get(s) == max.get()) cnt.getAndIncrement();
        });

        if(cnt.get() > 1) ans.set("?");
        else ans.set(ans.get().toUpperCase());


        System.out.println(ans.get());
    }
}