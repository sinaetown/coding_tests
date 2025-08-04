import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String word = br.readLine();
        String bomb = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
            while (true) {
                if (stack.size() >= bomb.length() && stack.peek() == bomb.charAt(bomb.length() - 1)) {
                    String out = "";
                    while (out.length() < bomb.length()) {
                        out = stack.pop() + out;
                    }
                    if (!out.equals(bomb)) {
                        for (int j = 0; j < out.length(); j++) {
                            stack.push(out.charAt(j));
                        }
                        break;
                    }
                } else break;
            }
        }
        if (stack.isEmpty()) System.out.println("FRULA");
        else {
            while (!stack.isEmpty()) {
                answer.append(stack.pop());
            }
            System.out.println(answer.reverse().toString());
        }
    }
}