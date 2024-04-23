import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++) {
            String p = br.readLine();
            int length = Integer.parseInt(br.readLine());
            String[] array = br.readLine().replace("[", "").replace("]", "").split(",");

            System.out.println(answer(p, length, array));
        }
    }

    private static String answer(String p, int length, String[] array) {
        StringBuilder ret = new StringBuilder();
        boolean flag = false;
        int sIdx = 0;
        int eIdx = length - 1;

        if(length == 0) {
            if(p.contains("D")) {
                ret = new StringBuilder("error");
            }
            else {
                ret = new StringBuilder("[]");
            }
        }
        else {
            for(int i=0;i<p.length();i++) {
                if(p.charAt(i) == 'R') flag = !flag;
                else if(p.charAt(i) == 'D') {
                    if(!flag) sIdx++;
                    else eIdx--;
                }
            }

            if(sIdx > eIdx) {
                if(sIdx - eIdx == 1) ret = new StringBuilder("[]");
                else ret = new StringBuilder("error");
            }
            else {
                if(!flag) {
                    ret = new StringBuilder("[");
                    for(int i=sIdx;i<=eIdx;i++) {
                        ret.append(array[i]).append(",");
                    }

                    ret = new StringBuilder(ret.substring(0, ret.length() - 1));
                    ret.append("]");
                }
                else {
                    ret = new StringBuilder("[");
                    for(int i=eIdx;i>=sIdx;i--) {
                        ret.append(array[i]).append(",");
                    }

                    ret = new StringBuilder(ret.substring(0, ret.length() - 1));
                    ret.append("]");
                }
            }
        }

        return ret.toString();
    }
}