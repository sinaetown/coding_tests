import java.util.*;

class Solution {
    public int solution(int[] people, int limit){
        int answer = 0;
        Arrays.sort(people);
        int ind = 0;
        for (int i = people.length - 1; i >= ind; i--) {
            int left = limit - people[i];
            if (left >= people[ind]) {
                ind++;
            }
            answer++;
        }
        return answer;
    }
}