import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int x, y;
    private static int[][] map;
    private static Queue<Position> queue = new LinkedList<>();

    private static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        map = new int[y][x];

        for(int i=0;i<y;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<x;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) queue.add(new Position(j, i));
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        while(!queue.isEmpty()) {
            Position current = queue.poll();

            for(int i=0;i<4;i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if(nextX >= 0 && nextX < x && nextY >= 0 && nextY < y && map[nextY][nextX] == 0) {
                    queue.add(new Position(nextX, nextY));
                    map[nextY][nextX] = map[current.y][current.x] + 1;
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i=0;i<y;i++) {
            for(int j=0;j<x;j++) {
                if(map[i][j] == 0) return -1;
                ans = Math.max(ans, map[i][j]);
            }
        }

        if(ans == 1) return 0;
        else return ans - 1;
    }
}