import java.util.*;

class Solution {
        public class ScoreWithInd {
        double score;
        int ind;

        public ScoreWithInd(double score, int ind) {
            this.score = score;
            this.ind = ind;
        }
    }

    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        List<ScoreWithInd> rank = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            rank.add(new ScoreWithInd((score[i][0] + score[i][1]) / 2.0, i));
        }
        Collections.sort(rank, new Compare());

        List<Double> chk = new ArrayList<>();
        int r = 1;
        int repeat = 0;
        for (int q = 0; q < rank.size(); q++) {
            if (!chk.contains(rank.get(q).score)) {
                chk.add(rank.get(q).score);
                repeat = r;
                answer[rank.get(q).ind] = r++;
            } else {
                answer[rank.get(q).ind] = repeat;
                r++;
            }
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public class Compare implements Comparator<ScoreWithInd> {
        @Override
        public int compare(ScoreWithInd o1, ScoreWithInd o2) {
            if (o2.score > o1.score) return 1;
            if (o2.score < o1.score) return -1;
            return 0;
        }
    }
}