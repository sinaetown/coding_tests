import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        System.out.print(set);
        if (set.size() < nums.length / 2) {
            answer = set.size();
        }
        else{
            answer = nums.length/2;
        }
        return answer;
    }
}