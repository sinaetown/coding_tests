import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int len = A.length - 1;
        int index = len;
        for (int i = len; i >= 0; i--) {
            if (A[i] < B[index]) {
                answer++;
                index--;
            }
        }
        return answer;
    }
        
}