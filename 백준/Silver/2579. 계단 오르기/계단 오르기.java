import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n];
        dp = new Integer[n];
        int ans = 0;

        for(int i=0;i<n;i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        if(n == 1) {
            ans = data[0];
        }
        else if(n == 2) {
            ans = data[0] + data[1];
        }
        else if(n == 3){
            ans = Math.max(data[2] + data[1], data[2] + data[0]);
        }
        else {
            dp[0] = data[0];
            dp[1] = data[0] + data[1];
            dp[2] = Math.max(data[2] + data[1], data[2] + data[0]);

            ans = find(n-1, data);
        }

        System.out.println(ans);
    }

    private static int find(int n, int[] data) {
        if(dp[n] == null) {
            dp[n] = Math.max(data[n] + data[n - 1] + find(n - 3, data), data[n] + find(n - 2, data));
        }

        return dp[n];
    }
}