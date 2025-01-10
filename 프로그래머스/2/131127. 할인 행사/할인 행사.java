import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount){
        int answer = 0;
        int[] counts = new int[want.length];
        for (int i = 0; i < discount.length - 9; i++) {
            String[] sub = new String[10];
            int ind = 0;
            int index = 0;
            for (int j = i; j < i + 10; j++) {
                sub[ind++] = discount[j];
            }
            for (int a = 0; a < want.length; a++) {
                counts[index++] = count(want[a], sub);
            }
            int chk =0;
            for (int b = 0; b < counts.length; b++) {
                if (counts[b] == number[b])chk++;
            }
            if(chk==counts.length) answer++;
        }
        return answer;
    }
    
    public int count(String s, String[] arr) {
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(s)) answer++;
        }
        return answer;
    }
}