import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            if (split.length == 2) {
                stack.add(Integer.parseInt(split[1]));
            } else {
                if (Integer.parseInt(split[0]) == 2) {
                    if (!stack.isEmpty()) bw.write(stack.pop() + "\n");
                    else bw.write(-1 + "\n");
                } else if (Integer.parseInt(split[0]) == 3) {
                    bw.write(stack.size() + "\n");
                } else if (Integer.parseInt(split[0]) == 4) {
                    if (!stack.isEmpty()) bw.write(0 + "\n");
                    else bw.write(1 + "\n");
                } else if (Integer.parseInt(split[0]) == 5) {
                    if (!stack.isEmpty()) bw.write(stack.peek() + "\n");
                    else bw.write(-1 + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}