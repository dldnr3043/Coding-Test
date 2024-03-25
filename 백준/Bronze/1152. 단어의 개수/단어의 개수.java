import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = "";

        str = sc.nextLine().trim();

        String[] cnt = str.split(" ");
        int ans = cnt.length;

        if(cnt.length == 1 && "".equals(cnt[0])) ans = 0;

        System.out.println(ans);
    }
}