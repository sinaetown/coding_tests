import java.lang.*;
import java.util.*;
class Solution {
    public String solution(String s) {
       String part = "";
        String answer = "";
        String[] splitted = s.split(" ");
        List<String> l =new ArrayList<>();
        List<String> real =new ArrayList<>();

//        [^ ]*$
        System.out.println("splitted: " +Arrays.toString(splitted));

        for (int a = 0; a<splitted.length; a++) {
            for (int i = 0; i < splitted[a].length(); i++) {
                if (i % 2 == 0) {
                    part += Character.toUpperCase(splitted[a].charAt(i));
                } else {
                    part += Character.toLowerCase(splitted[a].charAt(i));
                }
            }
            l.add(part);
            part = "";

        }
        int p =0;
        for(String ll : l){
            if(ll.length()!=0){
                real.add(ll);
            }
        }
        System.out.println(real);

        for(int c = 0; c < s.length(); c++){
            if(s.charAt(c)==' '){
                answer+= ' ';
            }
            else{
                answer+=real.get(p);
                System.out.println("c : "+c);
                c+=(real.get(p)).length()-1;
                p++;
            }
        }
        return answer;
    }
}