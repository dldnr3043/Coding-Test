import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static boolean[] visited;
    private static int[][] edge;
    private static int n = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int v = Integer.parseInt(split[2]);
        visited = new boolean[n + 1];
        edge = new int[n + 1][n + 1];

        for(int i=0;i<m;i++) {
            String[] tmp = br.readLine().split(" ");
            int s = Integer.parseInt(tmp[0]);
            int e = Integer.parseInt(tmp[1]);

            edge[s][e] = 1;
            edge[e][s] = 1;
        }

        dfs(v);
        System.out.println();

        for(int i=1;i<=n;i++) {
            visited[i] = false;
        }
        bfs(v);
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);

        while(!q.isEmpty()) {
            int num = q.poll();
            System.out.print(num + " ");
            visited[num] = true;

            for(int i=1;i<=n;i++) {
                if(edge[num][i] == 1) {
                    if(!q.contains(i) && !visited[i]) q.add(i);
                }
            }
        }
    }

    private static void dfs(int v) {
        // 1. 방문한 경우 종료
        if(visited[v]) return;

        // 2. 방문 표시
        visited[v] = true;
        System.out.print(v + " ");

        // 3. 다음칸 방문
        for(int i=1;i<=n;i++) {
            if(edge[v][i] == 1) {
                dfs(i);
            }
        }
    }
}