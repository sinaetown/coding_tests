import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        Set<Integer> num = new HashSet<>();
        for(int i = 0; i <k; i++){
            for(int a : arr){
            num.add(a);
            }
        }
        
        int index=0;
        List<Integer> l = new ArrayList<>();
        
        for(int p = 0; p < arr.length; p++){
            if(num.contains(arr[p])){
                l.add(arr[p]);
                num.remove(arr[p]);
            }
        }
        
       System.out.println(l);
        int[] answer = new int[k];
        if(k < l.size()){
            for(int i = 0; i < k; i++){
                answer[i] = l.get(i);
            }
        }
        else{
            int ind = 0;
            for(int j = 0; j < l.size(); j++){
                answer[ind++] = l.get(j);
            }
            for(int j = 0; j < k-l.size(); j++){
                answer[ind++] = -1;
            }
        }
//         for(int i = 0; i < k; i++){
//             if(l.size()<i){
//                 answer[i]=-1;
//             }
//             else{
//                 answer[i] = l.get(i);
//             }
            
//         }
//         System.out.println(Arrays.toString(answer));
        return answer;
    }
}