import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] map, answer;
    private static boolean[] visited;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        answer = new int[n][n];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++) {
            visited = new boolean[n];
            dfs(i);

            for(int j=0;j<n;j++) {
                if(visited[j]) {
                    answer[i][j] = 1;
                }
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int index) {
        for(int i=0;i<n;i++) {
            if(i == index) continue;

            if(map[index][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }


    }
}