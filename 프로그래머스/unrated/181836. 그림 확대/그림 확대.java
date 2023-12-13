import java.util.*;

class Solution {
    public String[] solution(String[] picture, int k) {
        
        List<String> myList = new ArrayList<>();
        String str = "";
        int index = 0;
        for(int i = 0; i < picture.length; i++){
            for(int j = 0; j < picture[i].length(); j++){
                for(int m = 0; m < k; m++){
                    str+=picture[i].charAt(j);
                }
            }
            for(int n = 0; n < k; n++){
                    myList.add(str);
            }
            str="";
        }
        System.out.print(myList);
        String[] answer = new String[myList.size()];
        for(int i = 0; i < myList.size(); i++){
            answer[i] = myList.get(i);
        }
        return answer;
    }
}