import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            stack = new Stack<>();
            for (int j = 0; j < line.length(); j++) {
                Character alphabet = line.charAt(j);
                if (!stack.isEmpty() && stack.peek() == alphabet) {
                    stack.pop();
                } else {
                    stack.push(alphabet);
                }
            }
            if (stack.isEmpty()) sum++;
        }
        System.out.println(sum);
    }
}