import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static PriorityQueue<Integer> pqMin;
    private static PriorityQueue<Integer> pqMax;
    private static Map<Integer, Integer> map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++) {
            int k = Integer.parseInt(br.readLine());
            pqMin = new PriorityQueue<>();
            pqMax = new PriorityQueue<>(Collections.reverseOrder());
            map = new HashMap<>();

            for(int j=0;j<k;j++) {
                String[] split = br.readLine().split(" ");
                String cmd = split[0];
                int n = Integer.parseInt(split[1]);

                execCmd(cmd, n);
            }

            if(map.isEmpty()) {
                System.out.println("EMPTY");
            }
            else {
                int n = removeMap(pqMax);
                System.out.println(n + " " + (!map.isEmpty() ? removeMap(pqMin) : n));
            }
        }
    }

    private static void execCmd(String cmd, int n) {
        if("I".equals(cmd)) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            pqMin.add(n);
            pqMax.add(n);
        }
        else if("D".equals(cmd) && !map.isEmpty()) {
            PriorityQueue<Integer> tmpQ = n == 1 ? pqMax : pqMin;
            removeMap(tmpQ);
        }
    }

    private static int removeMap(PriorityQueue<Integer> queue) {
        int num;

        while(true) {
            num = queue.poll();

            int cnt = map.getOrDefault(num, 0);

            if(cnt == 0) continue;
            else if(cnt == 1) map.remove(num);
            else map.put(num, cnt - 1);

            break;
        }

        return num;
    }
}