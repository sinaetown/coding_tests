import java.util.*;
import java.math.BigDecimal;

class Solution {
     public class Pair {
        BigDecimal failure;
        int stage;

        public Pair(BigDecimal failure, int stage) {
            this.failure = failure;
            this.stage = stage;
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int ind = 0;
        List<Pair> fails = new ArrayList<>();
        for (int a = 1; a <= N; a++) {
            int stage = a;
            double failed = 0;
            double total = 0;
            for (int b = 0; b < stages.length; b++) {
                if (stages[b] == N + 1) stages[b] = 502;
                if (stages[b] >= stage) {
                    total++;
                }
                if (stages[b] == stage) {
                    failed++;
                }
            }
            if (total != 0) {
                BigDecimal cal = new BigDecimal(Double.toString(failed / total));
                fails.add(new Pair(cal, stage));
            } else fails.add(new Pair(BigDecimal.ZERO, stage));
        }

        fails.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.failure.compareTo(o1.failure);
            }

            ;
        });
        for (Pair p : fails) {
            answer[ind++] = p.stage;
        }
        return answer;
    }
}