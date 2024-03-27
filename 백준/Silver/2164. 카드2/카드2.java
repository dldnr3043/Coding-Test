import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++) {
            q.add(i + 1);
        }

        while(true) {
            if(q.size() == 1) break;
            q.poll();
            q.add(q.poll());

        }

        System.out.println(q.poll());
    }
}