import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer order = new StringTokenizer(br.readLine());
            String s = order.nextToken();
            if (s.equals("push")) {
                stack.push(Integer.parseInt(order.nextToken()));
            } else if (s.equals("pop")) {
                if (stack.isEmpty()) bw.write("-1\n");
                else bw.write(String.valueOf(stack.pop()) + "\n");
            } else if (s.equals("size")) {
                bw.write(String.valueOf(stack.size()) + "\n");
            } else if (s.equals("empty")) {
                if (stack.isEmpty()) bw.write("1\n");
                else bw.write("0\n");
            } else if (s.equals("top")) {
                if (stack.isEmpty()) bw.write("-1\n");
                else bw.write(String.valueOf(stack.peek()) + "\n");
            }
        }
        bw.flush();
    }
}