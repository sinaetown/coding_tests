
class Solution {
    public String solution(String myString) {
        String answer = "";
        for(int i =0;i<myString.length();i++){
            if(myString.charAt(i)=='a' || myString.charAt(i)=='A'){
                answer+='A';
            }
            else{
                answer+=Character.toLowerCase(myString.charAt(i));
            }
        }
        return answer;
    }
}