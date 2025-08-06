import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean insideTag = false;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '<') {
                insideTag = true;
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(line.charAt(i));
            } else if (line.charAt(i) == '>') {
                insideTag = false;
                sb.append(line.charAt(i));
            } else if (insideTag) {
                sb.append(line.charAt(i));
            } else if (!insideTag) {
                if (line.charAt(i) == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(line.charAt(i));
                } else stack.push(line.charAt(i));
            }
        }
        while (!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb.toString());
    }
}