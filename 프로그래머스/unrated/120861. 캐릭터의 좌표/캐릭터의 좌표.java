import java.util.*;

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        
        List<Integer> l = new ArrayList<>();
        l.add(0);
        l.add(0);
        
        for(String k : keyinput){
            if(k.equals("left")){
                if((board[0]-1)/2*(-1) <= l.get(0)-1){
                    l.set(0,l.get(0)-1);
                }
            }
            else if(k.equals("right")){
                 if((board[0]-1)/2 >= l.get(0)+1){
                   l.set(0,l.get(0)+1);
                }
            }
            else if(k.equals("up")){
                if((board[1]-1)/2 >= l.get(1)+1){
                   l.set(1,l.get(1)+1);
                }
                
            }
            else if(k.equals("down")){
                 if((board[1]-1)/2*(-1) <= l.get(1)-1){
                    l.set(1,l.get(1)-1);
                }
            }
        }
        int[] answer = new int[l.size()];
        for(int i = 0; i < l.size(); i++){
            answer[i] = l.get(i);
        }
        return answer;
    }
}