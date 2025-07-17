import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < targets.length; i++) list.add(targets[i]);
        Collections.sort(list, new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int[] arr2){
                return arr1[1]-arr2[1];
            }
        });
        int end = -1;
        for(int i = 0; i < list.size(); i++){
            if(end <= list.get(i)[0]){
                answer++;
                end = list.get(i)[1];
            }
        }
        return answer;
    }
}