import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        String line = br.readLine();
        int sum = 0;
        for (int i = 0; i < line.length(); i++) {
            Character current = line.charAt(i);
            Character next = ' ';
            if (i < line.length() - 1) {
                next = line.charAt(i + 1);
            }
            if (current == '(' && next == ')') {
                sum += stack.size();
                i++;
            } else if (current == '(') stack.add('(');
            else if (current == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}