import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());
        int[] inputs = new int[cnt];

        for(int i=0;i<cnt;i++) {
            inputs[i] = sc.nextInt();
        }

        // 1. sort array
        Arrays.sort(inputs);

        // 2. 산술평균
        int arithmeticMean = getArithmeticMean(inputs);
        System.out.println(arithmeticMean);

        // 3. 중앙값
        int median = getMedian(inputs);
        System.out.println(median);

        // 4. 최빈값
        int mode = getMode(inputs);
        System.out.println(mode);

        // 5. 범위
        int range = getRange(inputs);
        System.out.println(range);
    }

    private static int getArithmeticMean(int[] inputs) {
        return (int) Math.round(Arrays.stream(inputs).sum() / (double) inputs.length);
    }
    private static int getMedian(int[] inputs) {
        return inputs[inputs.length / 2];
    }
    private static int getMode(int[] inputs) {
        Integer[] temp = Arrays.stream(inputs).boxed().toArray(Integer[]::new);
        Set<Integer> set = new HashSet<>(Arrays.asList(temp));
        Map<Integer, Integer> map = new HashMap<>();

        set.forEach(s->{
            int cnt = 0;

            for(int i=0;i<inputs.length;i++) {
                if(s == inputs[i]) {
                    cnt++;
                }
            }

            map.put(s, cnt);
        });

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparing(Map.Entry::getValue));

        int modeNum = list.get(list.size()-1).getValue();
        List<Integer> modeList = new ArrayList<>();

        list.forEach(m->{
            if(m.getValue() == modeNum) modeList.add(m.getKey());
        });

        Collections.sort(modeList);

        if(modeList.size() == 1) return modeList.get(0);
        return modeList.get(1);
    }
    private static int getRange(int[] inputs) {
        int min = Arrays.stream(inputs).min().getAsInt();
        int max = Arrays.stream(inputs).max().getAsInt();

        return max - min;
    }
}