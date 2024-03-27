import com.sun.source.tree.NewArrayTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static Integer[][] dp = new Integer[41][2];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] inputs = new int[n];

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i=0;i<n;i++) {
            inputs[i] = Integer.parseInt(br.readLine());

            fibonacci(inputs[i]);

            System.out.println(dp[inputs[i]][0] + " " + dp[inputs[i]][1]);
        }
    }

    private static Integer[] fibonacci(int n) {
        if(dp[n][0] == null && dp[n][1] == null) {
            dp[n][0] = fibonacci(n-1)[0] + fibonacci(n-2)[0];
            dp[n][1] = fibonacci(n-1)[1] + fibonacci(n-2)[1];
        }
        return dp[n];
    }
}