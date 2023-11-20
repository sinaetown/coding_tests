import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int max = 0;
        int second_max = 0;

        List<Integer> ll= new ArrayList<Integer> ();
        for(int i = 0; i < numbers.length; i++){
            ll.add(numbers[i]);
        }
       
       for(int i = 0; i < numbers.length; i++){
          if(max <= numbers[i]){
              max = numbers[i];
          }
       }
        int max_index = ll.indexOf(max);
        System.out.print("MAX INDEX = "+ max_index);
        
        ll.remove(max_index);
        System.out.print(ll);
        
        for(int i = 0; i < ll.size(); i++){
          if(second_max <= ll.get(i)){
              second_max = ll.get(i);
          }
       }
        
        System.out.print(" MAX="+max+" ");
        
       
        System.out.print(second_max);
        answer=max*second_max;
        return answer;
    }
}