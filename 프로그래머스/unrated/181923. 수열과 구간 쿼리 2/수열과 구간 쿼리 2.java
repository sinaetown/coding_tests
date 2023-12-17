import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int index =0;
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Queue<Integer> pq = new PriorityQueue<>();
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];
            for (int j = s; j <= e; j++) {
                if (arr[j] > k) {
                    pq.add(arr[j]);
                }
            }
            if(pq.peek()!=null){
                answer[index++] = pq.poll();
            }
            else{
                answer[index++] = 0-1;
            }
        }
        return answer;
    }
}