import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String mn = sc.nextLine();
        int n = Integer.parseInt(mn.split(" ")[0]);
        int m = Integer.parseInt(mn.split(" ")[1]);

        boolean[][] entireMap = new boolean[n][m];
        String[] h = new String[n];

        for(int i=0;i<n;i++) {
            h[i] = sc.nextLine();
        }

        for(int i=0;i<n;i++) {
            String[] split = h[i].split("");

            for(int j=0;j<m;j++) {
                entireMap[i][j] = "B".equals(split[j]);
            }
        }

        int minAns = Integer.MAX_VALUE;

        for(int i=0;i<=n-8;i++) {
            for(int j=0;j<=m-8;j++) {

                boolean[][] map = new boolean[8][8];

                for(int height=0;height<8;height++) {
                    for(int width=0;width<8;width++) {
                        map[height][width] = entireMap[i+height][j+width];
                    }
                }

                int[] point = {0, 0}; // 0 : x, 1 : y
                boolean[] linear = new boolean[64];
                int cnt = 0;

                for(int height=0;height<8;height++) {
                    for(int width=0;width<8;width++) {
                        linear[cnt] = map[point[1]][point[0]];
                        cnt++;

                        if(height % 2 == 0 ) {
                            // 오른쪽으로 진행 
                            if(point[0] < 7) {
                                point[0] += 1;
                            }
                            // 아래로 진행 (다음 줄)
                            else {
                                point[1] += 1;
                            }
                        }
                        else {
                            // 왼쪽으로 진행
                            if(point[0] > 0) {
                                point[0] -= 1;
                            }
                            // 아래로 진행 (다음 줄)
                            else {
                                point[1] += 1;
                            }
                        }
                    }
                }

                boolean[] firstBlack = new boolean[64];
                boolean[] firstWhite = new boolean[64];
                int fbCnt = 0;
                int fwCnt = 0;

                // first black
                if(linear[0]) {
                    firstBlack = Arrays.copyOf(linear, linear.length);
                    firstWhite = Arrays.copyOf(linear, linear.length);

                    firstWhite[0] = false;
                    fwCnt += 1;
                }
                // first white
                else {
                    firstBlack = Arrays.copyOf(linear, linear.length);
                    firstWhite = Arrays.copyOf(linear, linear.length);

                    firstBlack[0] = true;
                    fbCnt += 1;
                }

                for(int num=0;num<64-1;num++) {
                    if(firstBlack[num] == firstBlack[num+1]) {
                        firstBlack[num+1] = !firstBlack[num+1];
                        fbCnt++;
                    }
                }

                for(int num=0;num<64-1;num++) {
                    if(firstWhite[num] == firstWhite[num+1]) {
                        firstWhite[num+1] = !firstWhite[num+1];
                        fwCnt++;
                    }
                }

                int minCnt = Math.min(fwCnt, fbCnt);

                minAns = Math.min(minAns, minCnt);
            }
        }

        System.out.println(minAns);
    }
}