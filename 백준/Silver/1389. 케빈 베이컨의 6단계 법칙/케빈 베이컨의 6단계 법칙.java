import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int n, m;
    private static int[][] relationship = null;
    private static int[][] result = null;
    private static boolean[][] visited = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        relationship = new int[m][2];
        result = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            relationship[i][0] = Integer.parseInt(st.nextToken());
            relationship[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=n;i++) {
            bfs(i);
        }

        int[] sum = new int[n+1];

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                sum[i] += result[i][j];
            }
        }

        int tmpMin = 999999999;
        int tmpResult = 0;

        for(int i=1;i<=n;i++) {
            tmpMin = Integer.min(tmpMin, sum[i]);
        }

        for(int i=1;i<=n;i++) {
            if(sum[i] == tmpMin) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void bfs(int n) {
        int[] first = {n, 1};
        Queue<int[]> q = new LinkedList<>();
        q.add(first);
        visited[n][n] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int[] item : relationship) {
                if(item[0] == now[0]) {
                    int[] next = {item[1], now[1]+1};

                    if(!visited[n][next[0]]) {
                        visited[n][next[0]] = true;
                        result[n][next[0]] = now[1];
                        q.add(next);
                    }
                }
                if(item[1] == now[0]) {
                    int[] next = {item[0], now[1]+1};

                    if(!visited[n][next[0]]) {
                        visited[n][next[0]] = true;
                        result[n][next[0]] = now[1];
                        q.add(next);
                    }
                }
            }
        }
    }
}