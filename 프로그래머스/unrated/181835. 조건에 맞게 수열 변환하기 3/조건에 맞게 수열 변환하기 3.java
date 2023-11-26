class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[arr.length];
        int ind = 0;
        if(k%2==1){
            for(int i = 0; i < arr.length; i++){
            answer[ind++] = arr[i]*k;
        }
        }
        else{
            for(int i = 0; i < arr.length; i++){
            answer[ind++] = arr[i]+k;
        }
        }
        
        return answer;
    }
}