import java.util.*;
import java.lang.*;

class Solution {
    public String[] solution(String[] str_list) {
        String[] answer = {};
        List<String> given = new ArrayList<String>();
        List<String> res = new ArrayList<String>();
        int j = 0;

        for(String s : str_list){
            given.add(s);
        }
        
        int ind_l = given.indexOf("l");
        int ind_r = given.indexOf("r");
        System.out.println("ind_l = "+ind_l);
        System.out.println("ind_r = "+ind_r);
        
        if((ind_l < ind_r) && (ind_l != -1)){
            for(int i = 0; i < ind_l; i++){
                res.add(str_list[i]);
            }
        }
        else if((ind_l < ind_r) && (ind_l == -1)){
            for(int i = ind_r+1; i < str_list.length; i++){
                System.out.println("here");
                res.add(str_list[i]);
            }
        }
        else if((ind_l > ind_r) && (ind_r != -1)){
            for(int i = ind_r+1; i < str_list.length; i++){
                res.add(str_list[i]);
            }
        }
        else if((ind_l > ind_r) && (ind_r == -1)){
            for(int i = 0; i < ind_l; i++){
                res.add(str_list[i]);
            }
        }
        String[] a = new String[res.size()];
        for(int p = 0; p < res.size(); p++){
            System.out.print(res.get(p));
            a[j++] = res.get(p);
        }
        answer = a;

        return answer;
    }
}