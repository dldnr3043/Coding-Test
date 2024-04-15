import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int n, k;
    private static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int ans = 0;

        System.out.println(bfs(n));
    }

    private static int bfs(int n) {
        Queue<int[]> q = new LinkedList<>();
        int[] start = {n, 0};
        int ans = 0;

        q.add(start);

        while(!q.isEmpty()) {
            int[] temp = q.poll();
            visited[temp[0]] = true;

            if(temp[0] == k) {
                ans = temp[1];
                break;
            }

            int a = temp[0] - 1;
            int b = temp[0] + 1;
            int c = temp[0] * 2;
            
            if(a >= 0 && a <= 100000 && !visited[a]) q.add(new int[]{a, temp[1] + 1});
            if(b >= 0 && b <= 100000 && !visited[b]) q.add(new int[]{b, temp[1] + 1});
            if(c >= 0 && c <= 100000 && !visited[c]) q.add(new int[]{c, temp[1] + 1});
        }

        return ans;
    }
}