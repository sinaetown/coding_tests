class Solution {
    public int[] solution(int[] arr, int n) {
        int[] answer = new int[arr.length];
        int index = 0;
        if(arr.length%2 == 1){
            for(int i = 0; i < arr.length; i++){
                if(i%2==0){
                    answer[index++] = arr[i]+n;
                }
                else{
                    answer[index++] = arr[i];
                }
            }
        }
        else{
             for(int i = 0; i < arr.length; i++){
                if(i%2==1){
                    answer[index++] = arr[i]+n;
                }
                 else{
                    answer[index++] = arr[i];
                }
            }
        }
        return answer;
    }
}