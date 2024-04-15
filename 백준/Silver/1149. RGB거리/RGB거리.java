import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static Integer[][] dp;
    private static Integer[][] inputs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        inputs = new Integer[n][3];
        dp = new Integer[n][3];
        int sum = 0;

        for(int i=0;i<n;i++) {
            String[] split = br.readLine().split(" ");
            inputs[i][0] = Integer.parseInt(split[0]);
            inputs[i][1] = Integer.parseInt(split[1]);
            inputs[i][2] = Integer.parseInt(split[2]);
        }

        dp[0][0] = inputs[0][0];
        dp[0][1] = inputs[0][1];
        dp[0][2] = inputs[0][2];

        System.out.println(Math.min(dpMethod(n-1, 0), Math.min(dpMethod(n-1, 1), dpMethod(n-1, 2))));
    }

    private static int dpMethod(int n, int color) {
        if(dp[n][color] == null) {
            if(color == 0) {
                dp[n][color] = Math.min(dpMethod(n - 1, 1), dpMethod(n - 1, 2)) + inputs[n][color];
            }
            else if(color == 1) {
                dp[n][color] = Math.min(dpMethod(n - 1, 0), dpMethod(n - 1, 2)) + inputs[n][color];
            }
            else {
                dp[n][color] = Math.min(dpMethod(n - 1, 0), dpMethod(n - 1, 1)) + inputs[n][color];
            }
        }

        return dp[n][color];
    }
}