import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int r = Integer.parseInt(split[1]);
        int c = Integer.parseInt(split[2]);

        int ans = findAns(r, c, n, 0);

        System.out.println(ans);
    }

    private static int findAns(int r, int c, int n, int ans) {
        if(n == 0) return ans;

        int h = (int) (r / Math.pow(2, n-1));
        int w = (int) (c / Math.pow(2, n-1));
        int position = -1;

        if(h == 0 && w == 0) {
            position = 0;
        }
        else if(h == 0 && w == 1) {
            position = 1;
            c -= (int) Math.pow(2, n - 1);
        }
        else if(h == 1 && w == 0) {
            position = 2;
            r -= (int) Math.pow(2, n - 1);
        }
        else {
            position = 3;
            r -= (int) Math.pow(2, n - 1);
            c -= (int) Math.pow(2, n - 1);
        }

        ans += position * (int) Math.pow(Math.pow(2, n - 1), 2);

        return findAns(r, c, n - 1, ans);
    }
}