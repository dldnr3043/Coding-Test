import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int n;
    private static int m;
    private static int start;
    private static int end;
    private static List<DistanceCost> list = new ArrayList<>();
    private static boolean[] visited;
    private static int[] costUpdate;

    public static void main(String[] args) throws IOException {
        // 1. input data 세팅
        setInputData();

        // 2. solve
        solve();

        // 3. print answer
        System.out.println(costUpdate[end-1]);
    }

    private static void solve() {
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.add(new City(start, 0));
        costUpdate[start - 1] = 0;

        while(!pq.isEmpty()) {
            // 1. 노드 꺼내기
            City city = pq.poll();

            if(!visited[city.index-1]) {
                // 2. 방문 처리
                visited[city.index - 1] = true;

                // 3. 인접 노드 갱신 & 넣기
                list.forEach(l -> {
                    if(l.start == city.index) {
                        if(costUpdate[l.end - 1] > city.cost + l.cost) {
                            costUpdate[l.end - 1] = city.cost + l.cost;
                            pq.add(new City(l.end, city.cost + l.cost));
                        }
                    }
                });
            }
        }
    }

    private static void setInputData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());


        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            DistanceCost dc = new DistanceCost(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            list.add(dc);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        costUpdate = new int[n];
        Arrays.fill(costUpdate, Integer.MAX_VALUE);
    }

    private static class DistanceCost {
        private int start;
        private int end;
        private int cost;

        DistanceCost(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    private static class City implements Comparable<City> {
        private int index;
        private int cost;

        public City(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        public int getCost() {
            return cost;
        }

        @Override
        public int compareTo(City other) {
            return Integer.compare(this.cost, other.getCost());
        }
    }
}