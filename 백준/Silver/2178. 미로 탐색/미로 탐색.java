import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[][] map;
    private static boolean[][] visited;
    private static final int[] flagX = {1, 0, -1, 0};
    private static final int[] flagY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0;i<n;i++) {
            String line = br.readLine();

            for(int j=0;j<m;j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        visited[0][0] = true;
        bfs();
        System.out.println(map[n-1][m-1]);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});

        while(!q.isEmpty()) {
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0;i<4;i++) {
                int nextX = nowX + flagX[i];
                int nextY = nowY + flagY[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
                    continue;
                if (visited[nextX][nextY] || map[nextX][nextY] == 0)
                    continue;

                q.add(new int[] {nextX, nextY});
                map[nextX][nextY] = map[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }
}