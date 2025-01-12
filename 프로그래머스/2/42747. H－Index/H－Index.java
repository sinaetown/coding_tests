import java.util.*;

class Solution {
    public int solution(int[] citations){
        Arrays.sort(citations);
        System.out.println(Arrays.toString(citations));
        int answer = citations[citations.length - 1];
        while (answer != 0) {
            if (answer <= count(answer, citations)[0]
                    && answer >= count(answer, citations)[1]) {
                return answer;
            }
            else answer--;
        }

        return answer;
    }

    public int[] count(int target, int[] citations) {
        int over = 0;
        int under = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= target) over++;
            else if (citations[i] <= target) under++;
        }
        return new int[]{over, under};
    }
}