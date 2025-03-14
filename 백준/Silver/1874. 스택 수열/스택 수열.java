import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int a = 1;
        boolean flag = false;
        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(br.readLine());
            for (; a <= number; a++) {
                stack.push(a);
                sb.append("+").append("\n");
            }
            if (stack.peek() == number) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                flag = true;
            }
        }
        if (flag) System.out.println("NO");
        else System.out.println(sb);
    }
}