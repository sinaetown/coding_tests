import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String res = "";
        for(int i = 0; i < a.length(); i++){
            if(Character.isLowerCase(a.charAt(i))){
                res+=Character.toUpperCase(a.charAt(i));
            }
            else{
                res+=Character.toLowerCase(a.charAt(i));
            }
        }
        System.out.print(res);
    }
}