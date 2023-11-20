class Solution {
    public String solution(String my_string) {
       
        String answer = "";
        char[] vowels = {'a','e','i','o','u'};
        // System.out.print('c'=='c');
        for(int i = 0; i < my_string.length(); i++){
            if(my_string.charAt(i) == 'a' ||
              my_string.charAt(i) == 'e' ||
              my_string.charAt(i) == 'i' ||
              my_string.charAt(i) == 'o' ||
              my_string.charAt(i) == 'u'){
                continue;
            }
            else{
                answer+=my_string.charAt(i);
            }
        }
       
        return answer;
    }
}