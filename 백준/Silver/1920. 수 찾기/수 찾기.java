import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for(int i=0;i<n;i++) {
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] input = new int[m];

        for(int i=0;i<m;i++) {
            input[i] = sc.nextInt();
        }

        Arrays.sort(a);

        Arrays.stream(input).forEach(i->{
            System.out.println(binarySearch(a, i));
        });
    }

    public static int binarySearch(int[] list, int num) {
        // 2. 변수 선언
        int startIndex = 0;
        int endIndex = list.length-1;

        // 3. 탐색
        while(startIndex <= endIndex) {
            int middle = (startIndex + endIndex) / 2;

            // 중간값보다 큰 경우
            if(num > list[middle]) {
                startIndex = middle+1;
            }
            // 중간값보다 작은 경우
            else if(num < list[middle]){
                endIndex = middle-1;
            }
            // 중간값인 경우
            else {
                return 1;
            }
        }

        return 0;
    }
}