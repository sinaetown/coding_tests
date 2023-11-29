import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        List<Integer> l = new ArrayList<>();
        int j = 0;
        for(int i = 0; i < arr.length; i++){
            l.add(Integer.parseInt(arr[i]));
        }
        Collections.sort(l);
        answer += String.valueOf(l.get(0));
        answer += " ";
        answer += String.valueOf(l.get(l.size()-1));
        return answer;
    }
}