import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        String answer = "";
        List<String> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] arr = (br.readLine()).split(" ");
            for (int j = 0; j < arr.length; j++) {
                stack.add(arr[j]);
            }
            while (!stack.isEmpty()) {
                if (stack.size() > 1) {
                    answer += stack.pop() + " ";
                }
                else{
                    answer += stack.pop();
                }
            }
            l.add(answer);
            answer="";
        }
        for(int ll = 0; ll < l.size(); ll++){
            System.out.println("Case #"+(ll+1)+": "+ l.get(ll));
        }
    }
}
