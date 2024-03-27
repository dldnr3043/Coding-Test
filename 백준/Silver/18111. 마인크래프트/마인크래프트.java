import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int m = Integer.parseInt(input.split(" ")[1]);
        int b = Integer.parseInt(input.split(" ")[2]);
        int[] map = new int[n * m];

        for(int i=0;i<n;i++) {
            String s = br.readLine();
            String[] split = s.split(" ");

            for(int j=0;j<m;j++) {
                map[(i*m)+j] = Integer.parseInt(split[j]);
            }
        }

        int ansTime = Integer.MAX_VALUE;
        int ansHeight = 0;

        for(int c=0;c<257;c++) {
            boolean flag = true;
            int tb = b;
            int time = 0;
            int height = 0;

            for(int i=0;i<map.length;i++) {
                // 블록 쌓기
                if(c > map[i]) {
                    tb -= c - map[i];
                    time += c - map[i];
                }
                // 블록 제거
                else if(c < map[i]) {
                    tb += map[i] - c;
                    time += 2 * (map[i] - c);
                }
            }

            if(tb < 0) continue;

            if(ansTime >= time) {
                ansTime = time;

                if(ansHeight < c) {
                    ansHeight = c;
                }
            }
        }

        System.out.println(ansTime + " " + ansHeight);
    }
}