import java.util.*;

class Solution {
    public static List<Long> operand = new ArrayList<>();
    public static List<Character> operator = new ArrayList<>();
    public static List<Character> uniqueOperator = new ArrayList<>();
    public static List<List<Character>> perm = new ArrayList<>();
    public static long answer = -1;
    
    public long solution(String expression) {
        //1) operator, operand 구별하기
        categorize(expression);
        //2)우선순위 조합 정하기
        permutation(new ArrayList<>(), new boolean[uniqueOperator.size()]);
        //3)계산하기
        solve();
        return answer;
    }
    
    public void solve(){
        for(int i = 0; i < perm.size(); i++){
            List<Long> nums = new ArrayList<>(operand);
            List<Character> ops = new ArrayList<>(operator);
            for(int j = 0; j < perm.get(i).size(); j++){
                char op = perm.get(i).get(j);
                for(int a = 0; a < ops.size(); a++){
                    if(ops.get(a) == op){
                        long num1 = nums.get(a);
                        long num2 = nums.get(a+1);
                        long newNum = cal(num1, num2, op);
                        
                        nums.remove(a); // 뒤부터 삭제
                        nums.remove(a);
                        ops.remove(a);

                        nums.add(a, newNum);
                        a--; // 같은 위치에서 재검사
                    }
                }
            }
            answer = Math.max(Math.abs(nums.get(0)), answer);
        }
    }

    public void permutation(List<Character> sub, boolean[] visited){
        if(uniqueOperator.size() == sub.size()){
            perm.add(new ArrayList<>(sub));
        }
        for(int i = 0; i < uniqueOperator.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                sub.add(uniqueOperator.get(i));
                permutation(sub, visited);
                sub.remove(sub.size()-1);
                visited[i] = false;
            }
        }
    }
    
    public void categorize(String expression){
        String num = "";
        for(int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
           if(c=='-' || c=='*' || c=='+') {
               if(!uniqueOperator.contains(c)) uniqueOperator.add(c);
               operator.add(c);
               operand.add(Long.parseLong(num));
               num = "";
           }
            else num+=c;
        }
        operand.add(Long.parseLong(num));
    }
    
    public long cal(long a, long b, char c){
        if(c=='+') return a+b;
        if(c=='-') return a-b;
        if(c=='*') return a*b;
        return 0;
    }
}