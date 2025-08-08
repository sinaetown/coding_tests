import java.util.*;

class Solution {
    public char[] arr;
    public int len;
    public int solution(String s) {
        int answer = 0;
        arr = s.toCharArray();
        len = s.length();
        for(int i = 0; i < len; i++){
            char[] afterSpin = rotateLeft(i);
            if(chk(afterSpin)) answer++;
        }
        return answer;
    }
    
    public boolean chk(char[] given){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < len; i++){
            if(isClosed(given[i])){
                if(stack.isEmpty()) return false;
                else{
                    if(isMatch(stack.peek(), given[i])) stack.pop();
                }
            }
            else{
                stack.push(given[i]);
            }
        }
        return stack.isEmpty();
    }
    
    public boolean isOpen(char a){
        return a =='[' || a =='{' || a == '(';
    }
    
    public boolean isClosed(char a){
        return a ==']' || a =='}' || a == ')';
    }
    
    public boolean isMatch(char a, char b){
        if(a=='[' && b == ']') return true;
        else if(a=='{' && b == '}') return true;
        else if(a=='(' && b == ')') return true;
        else return false;
    }
    
    public char[] rotateLeft(int cnt){
        char[] afterSpin = new char[len];
        for(int i = 0; i < len; i++){
            afterSpin[(len + i - cnt) % len] = arr[i];
        }
        return afterSpin;
    }
}