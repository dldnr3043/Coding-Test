import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());
        String[] inputs = new String[cnt];

        for (int i = 0; i < cnt; i++) {
            inputs[i] = sc.nextLine();
        }

        // 단어 중복 제거
        Set<String> set = new HashSet<>(Arrays.asList(inputs));
        List<String> list = new ArrayList<>();

        set.forEach(s->{
            list.add(s);
        });

        // 정렬
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()) return 1;
                else if(o1.length() < o2.length()) return -1;
                else return o1.compareTo(o2);
            }
        });

        list.forEach(System.out::println);
    }
}