import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] inputs = new int[n];

        for(int i=0;i<n;i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(inputs);

        if(n == 0) {
            System.out.println(0);
        }
        else {
            int rIdx = (int) Math.round(n * 0.15);
            int sum = 0;

            for(int i=rIdx;i<n-rIdx;i++) {
                sum += inputs[i];
            }


            System.out.println(Math.round(sum / (double) (n-2*rIdx)));
        }
    }
}