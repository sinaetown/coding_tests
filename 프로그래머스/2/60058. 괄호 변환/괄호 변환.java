import java.util.*;

class Solution {
    public String solution(String p) {
        //이미 올바른 괄호 문자열이라면
        if(isCorrect(p)){
            return p;
        }
        //그렇지 않다면 분리
        return recur(p);
    }
    
    public String recur(String p){
        if(p.isEmpty()) return p;
        //분리하고 둘 다 균형잡혔는지 확인하는 로직
        String[] separated = seperate(p);
        String u = separated[0];
        String v = separated[1];
        //u에 대해서 올바른 괄호 문자열이라면
        //v에 대해 재귀 돌리고 그 값을 u에 이어 붙이기
        if(isCorrect(u)){
            String res = recur(v);
            return u.concat(res);
        }
        // //u에 대해 올바르지 않다면
        else if(!isCorrect(u)){
            String res = recur(v);
            return '('+ res + ')' + operation(u);
        }
        return null;
    }
    
    public static String operation(String str){
        int len = str.length();
        //u의 첫 번쨰와 마지막 문자 제거
        String removed = str.substring(1,len-1);
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < removed.length(); i++){
            //괄호 방향 뒤집기
            if(removed.charAt(i)=='(') res.append(')');
            else res.append('(');
        }
        return res.toString();
    }
    
    //문자열을 u와 v로 분리하고 균형 잡혔는지 확인
    public String[] seperate(String p){
        for(int i = 1; i < p.length()+1; i++){
            String u = p.substring(0,i);
            String v = p.substring(i, p.length());
            if(isBalanced(u) && isBalanced(v)){
                return new String[]{u,v};
            }
        }
        return null;
    }
    
    // 균형 잡힌 괄호 문자열 확인
    public boolean isBalanced(String str){
        int open = 0;
        int closed = 0;
        for(char c : str.toCharArray()){
           if(c == '(') open++;
           else if(c == ')') closed++;
        }
        if(open == closed) return true;
         return false;
    }
    
    // 올바른 괄호 문자열 확인
     public boolean isCorrect(String str){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
           if(stack.isEmpty()){
               stack.push(str.charAt(i));
           }
            else{
                if(stack.peek() == '('
                   && str.charAt(i) == ')') stack.pop();
                else stack.push(str.charAt(i));
            }
        }
        if(stack.isEmpty()) return true;
        return false;
     }
}