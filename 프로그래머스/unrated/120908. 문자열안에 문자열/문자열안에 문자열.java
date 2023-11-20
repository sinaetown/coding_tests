class Solution {
    public int solution(String str1, String str2) {
        int answer = 2;
        int l = str2.length();
        for(int i = 0; i <= str1.length()-l; i++){
            //abc def ...
            //012 345 678
            System.out.println(str1.substring(i, i+l));
            if((str1.substring(i, i+l)).equals(str2)){
               answer = 1;
            }
            else{
                continue;
            }
            
        }
        return answer;
    }
}