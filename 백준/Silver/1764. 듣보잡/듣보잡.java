import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int n, m;
    private static String[] a = null;
    private static String[] b = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new String[n];
        b = new String[m];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = st.nextToken();
        }

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            b[i] = st.nextToken();
        }

        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(a));

        for(String s : b) {
            if(set.contains(s)) {
                list.add(s);
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        list.stream().forEach(System.out::println);
    }
}