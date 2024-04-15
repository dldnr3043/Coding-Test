import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int ans;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int i=0;i<tc;i++) {
            String[] split = br.readLine().split(" ");
            int w = Integer.parseInt(split[0]);
            int h = Integer.parseInt(split[1]);
            int s = Integer.parseInt(split[2]);

            int[][] map = new int[h][w];
            ans = 0;

            for(int j=0;j<s;j++) {
                String[] position = br.readLine().split(" ");
                map[Integer.parseInt(position[1])][Integer.parseInt(position[0])] = 1;
            }

            for(int a=0;a<h;a++) {
                for(int b=0;b<w;b++) {
                    dfs(b, a, map, w, h, false);
                }
            }

            System.out.println(ans);
        }
    }

    private static void dfs(int x, int y, int[][] map, int w, int h, boolean flag) {
        // 1. map 범위 벗어났거나 갈 수 없는 곳(0 : 배추 아닌 곳, 2 : 이미 방문한 곳)
        if(x < 0 || y < 0 || x >= w || y >= h || map[y][x] == 0 || map[y][x] == 2) return;

        // 2. 방문 처리
        map[y][x] = 2;
        int cnt = 0;
        for(int i=0;i<4;i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextY < 0 || nextX >= w || nextY >= h) continue;

            if(map[nextY][nextX] == 2) cnt++;
        }
        if(cnt == 0) ans++;

        // 3. 다음칸 방문
        for(int i=0;i<4;i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            dfs(nextX, nextY, map, w, h, true);
        }
    }
}