import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        for (int j = 0; j < n; j++) {
            String[] split = br.readLine().split(" ");
            if (split.length == 2) {
                if (split[0].equals("push_front")) {
                    deque.addFirst(Integer.parseInt(split[1]));
                } else {
                    deque.addLast(Integer.parseInt(split[1]));
                }
            } else {
                if (split[0].equals("pop_front")) {
                    if (deque.isEmpty()) bw.write(-1 + "\n");
                    else bw.write(deque.removeFirst() + "\n");
                } else if (split[0].equals("pop_back")) {
                    if (deque.isEmpty()) bw.write(-1 + "\n");
                    else bw.write(deque.removeLast() + "\n");
                } else if (split[0].equals("size")) {
                    bw.write(deque.size() + "\n");
                } else if (split[0].equals("empty")) {
                    if (deque.isEmpty()) bw.write("1\n");
                    else bw.write("0\n");
                } else if (split[0].equals("front")) {
                    if (deque.isEmpty()) bw.write(-1 + "\n");
                    else bw.write(deque.peekFirst() + "\n");
                } else if (split[0].equals("back")) {
                    if (deque.isEmpty()) bw.write(-1 + "\n");
                    else bw.write(deque.peekLast() + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}