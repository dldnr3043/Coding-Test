import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dx = {0, 1, 0, -1, 0, 0};
    private static final int[] dy = {-1, 0, 1, 0, 0, 0};
    private static final int[] dz = {0, 0, 0, 0, -1, 1};
    private static int n, m, h;
    private static int[][][] map;
    private static final Queue<Position> q = new LinkedList<>();

    private static class Position {
        int n;
        int m;
        int h;

        public Position(int h, int n, int m) {
            this.n = n;
            this.m = m;
            this.h = h;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][n][m];

        for(int i=0;i<h;i++) {
            for(int j=0;j<n;j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<m;k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 1) {
                        q.add(new Position(i, j, k));
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        while(!q.isEmpty()) {
            Position current = q.poll();

            for(int i=0;i<6;i++) {
                int nextX = current.m + dx[i];
                int nextY = current.n + dy[i];
                int nextH = current.h + dz[i];

                if((nextX >= 0 && nextX < m)
                        && (nextY >= 0 && nextY < n)
                        && (nextH >= 0 && nextH < h)
                        && map[nextH][nextY][nextX] == 0) {
                    q.add(new Position(nextH, nextY, nextX));
                    map[nextH][nextY][nextX] = map[current.h][current.n][current.m] + 1;
                }
            }
        }

        int ans = Integer.MIN_VALUE;

        for(int i=0;i<h;i++) {
            for(int j=0;j<n;j++) {
                for(int k=0;k<m;k++) {
                    if(map[i][j][k] == 0) return -1;
                    ans = Math.max(ans, map[i][j][k]);
                }
            }
        }
        
        if(ans == 1) return 0;
        else return ans - 1;
    }
}