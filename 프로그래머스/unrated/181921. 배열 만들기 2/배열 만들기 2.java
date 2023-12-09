import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        int[] answer;
        List<Integer> q = new ArrayList<Integer>();
        
        for(int i = l; i <= r; i++){
            if (!((Integer.toString(i)).contains("1") ||
                (Integer.toString(i)).contains("2") ||
                (Integer.toString(i)).contains("3") ||
                (Integer.toString(i)).contains("4") ||
                (Integer.toString(i)).contains("6") ||
                (Integer.toString(i)).contains("7") ||
                (Integer.toString(i)).contains("8") ||
                (Integer.toString(i)).contains("9") 
                 )){
                q.add(i);
            }
        }
        if(q.size()==0){
            int[] a = {-1};
            answer = a;
        }
        else{
            answer = new int[q.size()];
            int index = 0;
            for(int i = 0; i < q.size(); i++){
                answer[index++] = q.get(i);
            }
        }
        return answer;
    }
}