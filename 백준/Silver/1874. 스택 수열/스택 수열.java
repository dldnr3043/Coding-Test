import javax.management.relation.RoleUnresolvedList;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] inputs = new int[n];
        int[] sorted = new int[n];
        Stack<Integer> s = new Stack<>();
        StringBuilder answer = new StringBuilder();

        for(int i=0;i<n;i++) {
            inputs[i] = sc.nextInt();
            sorted[i] = i+1;
        }

        int current = 0;
        int sortedIdx = 0;

        while(current < n) {
            if(s.empty()) {
                s.push(sorted[sortedIdx]);
                sortedIdx++;
                answer.append("+");
            }

            int next = s.pop();

            if(next == inputs[current]) {
                current++;
                answer.append("-");
            }
            else if(next < inputs[current]) {
                s.push(next);
                s.push(sorted[sortedIdx]);
                sortedIdx++;
                answer.append("+");
            }
            else if(next > inputs[current]) {
                s.push(next);
                answer = new StringBuilder("NO");
                break;
            }
        }

        if("NO".equals(answer.toString())) {
            System.out.println(answer);
        }
        else {
            String[] split = answer.toString().split("");
            Arrays.stream(split).forEach(System.out::println);
        }
    }

}