import java.util.*;
class Solution {
    public int solution(int[] array) {
        int answer = 0;
        Arrays.sort(array);
        int i = (int)array.length/2;
        answer = array[i];
        return answer;
    }
}