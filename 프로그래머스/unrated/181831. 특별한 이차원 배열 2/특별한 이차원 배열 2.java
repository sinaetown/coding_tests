class Solution {
    public int solution(int[][] arr) {
        int answer = 0;
        loop1:
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j] == arr[j][i]){
                    System.out.print(i +" "+ j);
                    answer = 1;
                }
                else{
                    answer =0;
                    break loop1;
                }
            }
        }
        return answer;
    }
}