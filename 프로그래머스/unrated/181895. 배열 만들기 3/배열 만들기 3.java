import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
                int s = intervals[i][0];
                int e = intervals[i][1];
                for(int a = s; a < e+1; a++){
                    l.add(arr[a]);
                }
        }
        int[] answer = new int[l.size()];
        for(int i = 0; i < l.size(); i++){
            answer[i] = l.get(i);
        }
        return answer;
    }
}