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
            int cnt = 0;
            stack.push(word.charAt(i));
            if (stack.size() >= bomb.length()) {
                for (int j = 0; j < bomb.length(); j++) {
                    if (stack.get(stack.size() - bomb.length() + j) == bomb.charAt(j)) {
                        cnt++;
                    }

                }
                if (cnt == bomb.length()) {
                    for (int k = 0; k < bomb.length(); k++) stack.pop();
                }
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