import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        
        List<Integer> arr = new ArrayList<Integer>();
        
        for(int i : numlist){
            if(i%n==0){
                 arr.add(i);
            }
        }
        int[] answer = new int[arr.size()];
        int t = 0;
        for(int j = 0; j < arr.size(); j++){
            answer[t++] = arr.get(j);
        }
        return answer;
    }
}

// class Solution {
//     public int[] solution(int n, int[] numlist) {
//         int c = 0;
//         for(int i : numlist){
//             if(i%n==0){
//                 c++;
//             }
//         }
//         int[] answer = new int[c];
//         int index = 0;
//         for(int i : numlist){
            
//             if(i%n==0){
//                 answer[index++] = i;
//             }
//             else{
//                 continue;
//             }
//         }
//         return answer;
//     }
// }