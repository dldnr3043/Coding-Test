import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int r;
    private static int c;
    private static String[][] map;
    private static final int[][] move = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        // 1. input data 세팅
        setInputData();

        // 2. solve
        dfs(0, 0, 1, new HashSet<>(), new boolean[r][c]);

        // 3. print answer
        System.out.println(max);
    }

    private static void dfs(int x, int y, int distance, Set<String> visitedString, boolean[][] visited) {
        // 참조에 의한 복사 때문에 temp 변수 선언
//        Set<String> tempVisitedString = new HashSet<>(visitedString);
//        boolean[][] tempVisited = new boolean[visited.length][visited[0].length];
//        for(int i=0;i<visited.length;i++) {
//            tempVisited[i] = Arrays.copyOf(visited[i], visited[i].length);
//        }

        if(visited[x][y] || visitedString.contains(map[x][y])) {
            return;
        }

        visited[x][y] = true;
        visitedString.add(map[x][y]);
        if(max < distance) {
            max = distance;
        }

        for(int i=0;i<move.length;i++) {
            // 상하좌우 범위 벗어나는 것 체크
            int nextX = x + move[i][0];
            int nextY = y + move[i][1];
            if(!(nextX > -1 && nextX < r && nextY > -1 && nextY < c)) {
                continue;
            }

            // 지나간 알파벳 체크
            if(visitedString.contains(map[nextX][nextY])) {
                continue;
            }
            dfs(nextX, nextY, distance + 1, visitedString, visited);
        }
        visited[x][y] = false;
        visitedString.remove(map[x][y]);
    }

    private static void setInputData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new String[r][c];

        for(int i=0;i<r;i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().split("");
        }
    }
}