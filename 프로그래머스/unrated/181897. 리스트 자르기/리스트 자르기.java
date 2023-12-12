import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        List<Integer> l = new ArrayList<>();
        if(n==1){
            for(int i = 0; i <= slicer[1]; i++){
                l.add(num_list[i]);
            }
        }
        else if(n==2){
            for(int i = slicer[0]; i < num_list.length; i++){
                l.add(num_list[i]);
            }
        }
        else if(n==3){
            for(int i = slicer[0]; i <= slicer[1]; i++){
                l.add(num_list[i]);
            }
        }
        else{
            for(int i = slicer[0]; i <= slicer[1]; i+=slicer[2]){
                l.add(num_list[i]);
            }
        }
        int[] answer = new int[l.size()];
        for(int i = 0; i < l.size(); i++){
            answer[i] = l.get(i);
        }
        return answer;
    }
}