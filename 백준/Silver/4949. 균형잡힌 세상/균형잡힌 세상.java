import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s;

        while(true) {
            s = sc.nextLine();

            if(s.equals(".")) break;

            System.out.println(solve(s));
        }
    }

    public static String solve(String s) {
        Stack<String> stack = new Stack<>();
        String[] split = s.split("");
        boolean flag = true;

        for(int i=0;i<split.length;i++) {
            String c = split[i];

            if("(".equals(c) || "[".equals(c)) {
                stack.push(c);
            }
            else if(")".equals(c)) {
                if(stack.empty()) {
                    flag = false;
                    break;
                }
                
                if(!"(".equals(stack.pop())) {
                    flag = false;
                    break;
                }
            }
            else if("]".equals(c)) {
                if(stack.empty()) {
                    flag = false;
                    break;
                }

                if(!"[".equals(stack.pop())) {
                    flag = false;
                    break;
                }
            }
        }

        if(!flag) return "no";
        else {
            if(stack.empty()) return "yes";
            else return "no";
        }
    }
}