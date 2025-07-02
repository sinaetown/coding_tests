import java.util.*;

class Solution {
    public List<int[]> list = new ArrayList<>();
    public int answer = 0;
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        build(data, col);
        find(row_begin, row_end);
        return answer;
    }
    
    public void find(int row_begin, int row_end){
        for(int i = row_begin-1; i <= row_end-1; i++){
            int sub = 0;
            int[] arr = list.get(i);
            for(int j = 0; j < arr.length; j++){
                sub += (arr[j]%(i+1));
            }
            if(row_begin-1==i) answer = sub;
            else answer = answer ^ sub;
        }
    }
    
    public void build(int[][] data, int col){
        for(int i = 0; i < data.length; i++){
            int[] arr = data[i];
            list.add(arr);
        }
        list.sort(new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int[] arr2){
                if(arr1[col-1] == arr2[col-1]){
                    return arr2[0] - arr1[0];
                }
                return arr1[col-1] - arr2[col-1];
            }
        });
    }
}