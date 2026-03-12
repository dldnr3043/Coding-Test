import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int n;
    private static int[] a;
    private static int[] m;

    public static void main(String[] args) throws IOException {
        // 1. input data 세팅
        setInputData();

        // 2. solve
        for(int i=0;i<n;i++) {
            m[i] = 1;
            for(int j=0;j<i;j++) {
                if(a[j] < a[i] && m[i] < m[j] + 1) {
                    m[i] = m[j] + 1;
                }
            }
        }

        // 3. print answer
        int max = -1;
        for(int i=0;i<n;i++) {
            max = Math.max(m[i], max);
        }

        System.out.println(max);
    }

    private static void setInputData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = new int[n];
        a = new int[n];
        for(int i=0;i<n;i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
    }
}