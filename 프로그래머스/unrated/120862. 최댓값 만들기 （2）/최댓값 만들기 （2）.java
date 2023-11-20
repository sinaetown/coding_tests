import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        int potential_min = 0;
        int potential_max = 0;
        potential_min = numbers[0]*numbers[1];
        potential_max = numbers[numbers.length-2]*numbers[numbers.length-1];
        if(potential_min > potential_max){
            answer = potential_min;
        }
        else{
            answer = potential_max;
        }
        return answer;
    }
}