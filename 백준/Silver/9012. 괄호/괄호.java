import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        List<String> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int len = s.length();
            for (int p = 0; p < len; p++) {
                if (s.charAt(p) == '(') {
                    stack.push('(');
                } else { //s.charAt(p)==')'
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        stack.push(')');
                        break;
                    }
                }
            }
            if (stack.isEmpty()) {
                l.add("YES");
            } else {
                l.add("NO");
            }
            stack.clear();
        }
        for(int j = 0; j < l.size(); j++){
            System.out.println(l.get(j));
        }


    }
}
