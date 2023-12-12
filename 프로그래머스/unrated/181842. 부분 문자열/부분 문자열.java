class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        int len  = str1.length();
        for(int i  = 0; i < str2.length()-len+1; i++){
            if((str2.substring(i,i+len)).equals(str1)){
                answer=1;
            }
        }
        return answer;
    }
}