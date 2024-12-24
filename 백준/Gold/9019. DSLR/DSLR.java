import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] input = new int[n];
        int[] output = new int[n];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            input[i] = Integer.parseInt(st.nextToken());
            output[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n;i++) {
            bfs(input[i], output[i]);
        }
    }

    private static void bfs(int input, int output) {
        boolean visited[] = new boolean[10000];
        String command[] = new String[10000];

        Arrays.fill(command, "");

        Queue<Integer> q = new LinkedList<>();
        q.add(input);

        while(!q.isEmpty() && !visited[output]) {
            int now = q.poll();
            visited[now] = true;

            int D = new Dslr(now).D().getDslr();
            int S = new Dslr(now).S().getDslr();
            int L = new Dslr(now).L().getDslr();
            int R = new Dslr(now).R().getDslr();

            if(!visited[D]) {
                q.add(D);
                visited[D] = true;
                command[D] = command[now] + "D";
            }
            if(!visited[S]) {
                q.add(S);
                visited[S] = true;
                command[S] = command[now] + "S";
            }
            if(!visited[L]) {
                q.add(L);
                visited[L] = true;
                command[L] = command[now] + "L";
            }
            if(!visited[R]) {
                q.add(R);
                visited[R] = true;
                command[R] = command[now] + "R";
            }
        }

        System.out.println(command[output]);
    }

    private static class Dslr {
        private int d1;
        private int d2;
        private int d3;
        private int d4;

        public Dslr() {
            this.d1 = 0;
            this.d2 = 0;
            this.d3 = 0;
            this.d4 = 0;
        }

        public Dslr(int num) {
            this.d1 = num / 1000;
            this.d2 = (num % 1000) / 100;
            this.d3 = ((num % 1000) % 100) / 10;
            this.d4 = ((num % 1000) % 100) % 10;
        }

        public Dslr(int d1, int d2, int d3, int d4) {
            this.d1 = d1;
            this.d2 = d2;
            this.d3 = d3;
            this.d4 = d4;
        }

        public int getDslr() {
            return d1*1000 + d2*100 + d3*10 + d4;
        }

        public Dslr getNextDslr(String type) {
            if("D".equals(type)) {
                return this.D();
            }
            else if("S".equals(type)) {
                return this.S();
            }
            else if("L".equals(type)) {
                return this.L();
            }
            else if("R".equals(type)) {
                return this.R();
            }

            return null;
        }

        public Dslr D() {
            int currentDslr = this.getDslr();

            int transDslr = currentDslr * 2 % 10000;

            int newD1 = transDslr / 1000;
            int newD2 = (transDslr % 1000) / 100;
            int newD3 = ((transDslr % 1000) % 100) / 10;
            int newD4 = ((transDslr % 1000) % 100) % 10;

            return new Dslr(newD1, newD2, newD3, newD4);
        }

        public Dslr S() {
            int currentDslr = this.getDslr();

            int transDslr = (currentDslr == 0) ? 9999 : currentDslr-1;

            int newD1 = transDslr / 1000;
            int newD2 = (transDslr % 1000) / 100;
            int newD3 = ((transDslr % 1000) % 100) / 10;
            int newD4 = ((transDslr % 1000) % 100) % 10;

            return new Dslr(newD1, newD2, newD3, newD4);
        }

        public Dslr L() {
            return new Dslr(this.d2, this.d3, this.d4, this.d1);
        }

        public Dslr R() {
            return new Dslr(this.d4, this.d1, this.d2, this.d3);
        }
    }
}