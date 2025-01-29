import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        int extInd = getIndex(ext);
        int sortInd = getIndex(sort_by);
        for (int i = 0; i < data.length; i++) {
            if (val_ext >= data[i][extInd]) list.add(data[i]);
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[sortInd] - o2[sortInd];
            }
        });
        int[][] answer = new int[list.size()][4];
        int ind = 0;
        for (int[] a : list) answer[ind++] = a;
        return answer;
    }

    public int getIndex(String s) {
        int answer = 0;
        if (s.equals("date")) {
            answer = 1;
        } else if (s.equals("maximum")) {
            answer = 2;
        } else if (s.equals("remain")) {
            answer = 3;
        }
        return answer;
    }
}