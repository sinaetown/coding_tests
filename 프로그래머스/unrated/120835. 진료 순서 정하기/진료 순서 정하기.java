import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(int[] emergency) {
        int len = emergency.length;
        int[] answer = new int[len];
        List<Integer> l = new ArrayList<Integer>();
        List<Integer> inOrder = new ArrayList<Integer>();
        for(int i = 0; i < len; i++){
            l.add(emergency[i]);
            inOrder.add(emergency[i]);
        }
        Collections.sort(inOrder, Collections.reverseOrder());
        System.out.print("inorder: "+inOrder);
        int c = 0;
        for(int j : l){
            answer[c++] = inOrder.indexOf(j)+1;
        }
        return answer;
    }
}