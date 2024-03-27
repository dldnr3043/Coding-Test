import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] inputs = new String[n];
        int[] s = new int[n];
        int idx = -1;
        StringBuffer sb = new StringBuffer();

        for(int i=0;i<n;i++) {
            inputs[i] = sc.nextLine();

            if(inputs[i].contains("push")) {
                s[++idx] = Integer.parseInt(inputs[i].split(" ")[1]);
            }
            else if("pop".equals(inputs[i])) {
                if(idx == -1) sb.append(-1).append("\n");
                else {
                    sb.append(s[idx]).append("\n");
                    s[idx] = 0;
                    idx--;
                }
            }
            else if("size".equals(inputs[i])) {
                sb.append(idx + 1).append("\n");
            }
            else if("empty".equals(inputs[i])) {
                if(idx == -1) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else if("top".equals(inputs[i])) {
                if(idx == -1) sb.append(-1).append("\n");
                else {
                    sb.append(s[idx]).append("\n");
                }
            }
        }
        System.out.println(sb);
    }

}