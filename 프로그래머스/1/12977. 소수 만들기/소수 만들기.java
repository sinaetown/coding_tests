import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int sum = 0;
        List<Integer> l = new ArrayList<>();
        for(int a = 0; a < nums.length-2; a++){
            for(int b = a+1; b < nums.length-1; b++){
                for(int c = b+1; c < nums.length; c++){
                    sum = nums[a]+nums[b]+nums[c];
                    for(int d = 1; d <= sum; d++){
                        if(sum%d==0){
                            l.add(d);
                        }
                    }
                    if(l.size()==2){
                        answer += 1;
                    }
                    l.clear();
                }
            }
        }
        return answer;
    }
}