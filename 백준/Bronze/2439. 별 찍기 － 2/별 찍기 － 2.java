import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input;

        input = sc.nextInt();

        for(int i=1;i<=input;i++) {
            for(int j=input;j>=1;j--) {
                if(i>=j) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}