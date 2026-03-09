import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    private static final List<Integer> list = new ArrayList<>();
    private static final PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++) {
            int x = Integer.parseInt(br.readLine());
            printAnswerPriorityQueue(x);
        }
    }

    /**
     * 시간초과
     * @param x
     */
    private static void printAnswer(int x) {
        if(x == 0) {
            Collections.sort(list);
            int answer = (!list.isEmpty()) ? list.remove(0) : 0;
            System.out.println(answer);
        } else {
            list.add(x);
        }
    }

    private static void printAnswerPriorityQueue(int x) {
        if(x == 0) {
            int answer = (pq.isEmpty()) ? 0 : pq.poll();
            System.out.println(answer);
        } else {
            pq.add(x);
        }
    }
}