import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        Arrays.sort(dots, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        boolean[] chk = new boolean[dots.length];
        List<int[]> t = new ArrayList<>();
        List<int[]> f = new ArrayList<>();
        for (int i = 0; i < dots.length - 1; i++) {
            chk[i] = true;
            double m = 0;
            double n = 0;
            for (int j = i + 1; j < dots.length; j++) {
                chk[j] = true;
                for (int c = 0; c < chk.length; c++) {
                    if (chk[c]) {
                        t.add(new int[]{dots[c][0], dots[c][1]});
                    } else {
                        f.add(new int[]{dots[c][0], dots[c][1]});
                    }
                }
              
                double tx = t.get(1)[0] - t.get(0)[0];
                double ty = t.get(1)[1] - t.get(0)[1];
                m = ty / tx;

                double fx = f.get(1)[0] - f.get(0)[0];
                double fy = f.get(1)[1] - f.get(0)[1];
                n = fy / fx;

               if (m == n) return 1;
                chk[j] = false;
                t.clear();
                f.clear();
            }
            chk[i] = false;
        }
        return answer;
    }
}