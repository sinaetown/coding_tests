import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
       
        List <Integer> myL = new ArrayList<Integer>();
        for(int i = 0; i < intStrs.length; i++){
            String sliced = intStrs[i].substring(s,s+l);
            int sNum = Integer.parseInt(sliced);
            if( sNum > k){
                myL.add(sNum);
            }
        }
        int[] answer = new int [myL.size()];
        for(int i = 0; i < myL.size(); i++){
            answer[i] = myL.get(i);
        }
        return answer;
    }
}