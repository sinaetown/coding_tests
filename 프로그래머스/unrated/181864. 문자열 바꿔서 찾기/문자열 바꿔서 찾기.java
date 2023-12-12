class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        String newStr = "";
        //Changed the string
        for(int i = 0; i < myString.length(); i++){
            if(myString.charAt(i)=='A'){
                newStr+='B';
            }
            else{
                newStr+='A';
            }
        }
        if (newStr.contains(pat)){
            answer =1;
        }
        else{
            answer =0;
        }
        return answer;
    }
}