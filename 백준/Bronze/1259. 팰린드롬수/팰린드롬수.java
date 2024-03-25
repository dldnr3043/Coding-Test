import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String input = sc.nextLine();
            if("0".equals(input)) break;

            // 길이가 짝수, 홀수일 때
            if(input.length() % 2 == 0) {
                // 절반 나누기
                String a = input.substring(0, input.length()/2);
                String b = input.substring(input.length() / 2, input.length());

                // 뒤에꺼 반대로
                StringBuffer sb = new StringBuffer(b);
                String reverse = sb.reverse().toString();

                // 비교
                if(a.equals(reverse)) {
                    System.out.println("yes");
                }
                else {
                    System.out.println("no");
                }
            }
            else {
                // 절반 나누기 (가운데 숫제 앞뒤로)
                String a = input.substring(0, input.length()/2);
                String b = input.substring(input.length()/2 +1, input.length());

                // 뒤에꺼 반대로
                StringBuffer sb = new StringBuffer(b);
                String reverse = sb.reverse().toString();

                // 비교
                if(a.equals(reverse)) {
                    System.out.println("yes");
                }
                else {
                    System.out.println("no");
                }
            }
        }
    }
}