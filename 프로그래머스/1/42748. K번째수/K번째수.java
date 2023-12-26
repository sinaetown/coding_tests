import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
       int[] answer = new int[commands.length];
        int k= 0;
        List<List<Integer>> sliced = new ArrayList<>();
        List<Integer> kList = new ArrayList<>();
        for (int c = 0; c < commands.length; c++) {
            int i = commands[c][0];
            int j = commands[c][1];
            k = commands[c][2];
            List<Integer> part = new ArrayList<>();
            kList.add(k);
            for (int cc = i - 1; cc < j; cc++) {
                part.add(array[cc]);
            }
            Collections.sort(part);
            sliced.add(part);
        }
 
        int index = 0;
        for(List<Integer> l : sliced){
            answer[index] = l.get(kList.get(index) - 1);
            index++;
        }
        return answer;
    }
}