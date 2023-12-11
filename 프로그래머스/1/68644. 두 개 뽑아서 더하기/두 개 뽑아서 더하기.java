import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        int[] sum_all = new int[numbers.length*numbers.length-1];
        int index = 0;
        int count = 0;
 
        for(int i = 0; i < numbers.length; i++){
            for(int j = i+1; j < numbers.length; j++){
                sum_all[index++] = numbers[i]+numbers[j];
                count++;
            }
        }
        sum_all=Arrays.copyOfRange(sum_all, 0, count);
        Arrays.sort(sum_all);
        // System.out.print(Arrays.toString(sum_all));
        int[] res = new int[sum_all.length];
        
        int res_index = 0;
        int res_count = 0;
        for(int i = 0; i < sum_all.length-1; i++){
            if(sum_all[i] != sum_all[i+1]){     
                res[res_index++] = sum_all[i];
                res_count++;
            }
        }
        res[res_index] = sum_all[sum_all.length-1];
        res=Arrays.copyOfRange(res, 0, res_count+1);
        System.out.print(Arrays.toString(res));
        answer = res;
        return answer;
    }
}