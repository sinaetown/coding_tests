import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String line = br.readLine();
            if (line.equals(".")) break;
            if (chk(line)) bw.write("yes\n");
            else if (!chk(line)) bw.write("no\n");
        }
        bw.flush();
        bw.close();
    }

    public static boolean chk(String line) {
        Stack<String> stack = new Stack<>();
        String[] split = line.split("");
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("(")) {
                stack.push("(");
            } else if (split[i].equals("[")) {
                stack.push("[");
            } else if (split[i].equals(")")) {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek().equals("(")) {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (split[i].equals("]")) {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek().equals("[")) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}