class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = new String[strArr.length];
        int index = 0 ;
        for(int i = 0; i < strArr.length; i++){
            if(i%2==1){
                answer[index++] = strArr[i].toUpperCase();
            }
            else{
                answer[index++] = strArr[i].toLowerCase();
            }
        }
        return answer;
    }
}