class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        int index = myString.lastIndexOf(pat);
        System.out.println(index);
        if(pat.length()>1){
            answer = myString.substring(0,index+pat.length());
        }
        else{
            answer = myString.substring(0,index+1);
        }
        return answer;
    }
}