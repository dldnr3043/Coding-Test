import com.sun.source.tree.NewArrayTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;

public class Main {
    static Integer[] dp = new Integer[5001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Arrays.fill(dp, 9999);

        dp[3] = 1;
        dp[5] = 1;

        int answer = dpSolve(n);

        answer = answer >= 9999 ? -1 : answer;

        System.out.println(answer);
    }

    private static int dpSolve(int n) {
        if(n < 3) return 9999;

        if(dp[n] == 9999) {
            dp[n] = Math.min(dpSolve(n-3), dpSolve(n-5)) + 1;
        }

        return dp[n];
    }
}