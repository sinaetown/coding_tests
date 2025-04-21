import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int i = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int j = 0; j < i; j++) {
            String[] split = br.readLine().split(" ");
            if (split[0].equals("push")) {
                queue.add(Integer.parseInt(split[1]));
            } else if (split[0].equals("pop")) {
                if (queue.isEmpty()) bw.write(-1 + "\n");
                else bw.write(queue.remove() + "\n");
            } else if (split[0].equals("size")) {
                bw.write(queue.size() + "\n");
            } else if (split[0].equals("empty")) {
                if (queue.isEmpty()) bw.write(1 + "\n");
                else bw.write(0 + "\n");
            } else if (split[0].equals("front")) {
                if (queue.isEmpty()) bw.write(-1 + "\n");
                else bw.write(queue.peekFirst() + "\n");
            } else if (split[0].equals("back")) {
                if (queue.isEmpty()) bw.write(-1 + "\n");
                else bw.write(queue.peekLast() + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

}