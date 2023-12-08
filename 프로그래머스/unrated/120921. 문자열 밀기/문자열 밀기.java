import java.util.*;

class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        StringBuffer sb = new StringBuffer(A);
        String C = A;
        while(!(C.equals(B))){
            char c = C.charAt(A.length() - 1);
            sb.delete(C.length() - 1, C.length());
            sb.insert(0, c);
            C=sb.toString();
            System.out.print(C);
            answer++;
            if(answer>A.length()){
                answer = -1;
                break;
            }
        }
        
        return answer;
    }
}