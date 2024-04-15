import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String[] split;
        boolean[] btn = new boolean[10];
        if(m > 0) {
            split = br.readLine().split(" ");
            for (String s : split) {
                btn[Integer.parseInt(s)] = true;
            }
        }

        System.out.println(Math.min(Math.abs(n-100), solved(n, btn)));
    }

    private static long solved(int n, boolean[] btn) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<1000000;i++) {
            String tmp = Integer.toString(i);
            String[] s = tmp.split("");
            boolean flag = false;

            for(String c : s) {
                if(Integer.parseInt(c) >= 0 && Integer.parseInt(c) <= 9) {
                    if(btn[Integer.parseInt(c)]) {
                        flag = true;
                        break;
                    }

                }
            }

            if(flag) continue;

            min = Math.min(min, s.length + Math.abs(n - i));
        }

        return min;
    }
}