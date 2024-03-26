import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());

        for(int i=0;i<cnt;i++) {
            Queue<Document> queue = new LinkedList<>();
            int documentCnt = sc.nextInt();
            int num = sc.nextInt();
            int[] documentsPriority = new int[documentCnt];
            int answer = 0;

            for(int j=0;j<documentCnt;j++) {
                documentsPriority[j] = sc.nextInt();
                queue.add(new Document(j, documentsPriority[j]));
            }

            while(!queue.isEmpty()) {
                int maxPriority = findMaxQueue(queue);
                Document document = queue.poll();

                if(document.getPriority() < maxPriority) {
                    queue.add(document);
                }
                else {
                    answer++;
                    if(document.getIndex() == num) break;
                }
            }

            System.out.println(answer);
        }
    }

    public static int findMaxQueue(Queue<Document> queue) {
        Optional<Document> maxPriorityDocument = queue.stream().max(Comparator.comparingInt(Document::getPriority));
        return maxPriorityDocument.get().getPriority();
    }

    public static class Document {
        private int index;
        private int priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

        public int getIndex() {
            return this.index;
        }
        public int getPriority() {
            return this.priority;
        }
    }
}