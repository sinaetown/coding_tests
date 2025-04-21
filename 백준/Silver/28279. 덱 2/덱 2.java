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
            if (split[0].equals("1")) {
                queue.addFirst(Integer.parseInt(split[1]));
            } else if (split[0].equals("2")) {
                queue.addLast(Integer.parseInt(split[1]));
            } else if (split[0].equals("3")) {
                if (queue.isEmpty()) bw.write(-1 + "\n");
                else bw.write(queue.removeFirst() + "\n");
            } else if (split[0].equals("4")) {
                if (queue.isEmpty()) bw.write(-1 + "\n");
                else bw.write(queue.removeLast() + "\n");
            } else if (split[0].equals("5")) {
                bw.write(queue.size() + "\n");
            } else if (split[0].equals("6")) {
                if (queue.isEmpty()) bw.write(1 + "\n");
                else bw.write(0 + "\n");
            } else if (split[0].equals("7")) {
                if (!queue.isEmpty()) bw.write(queue.peekFirst() + "\n");
                else bw.write(-1 + "\n");
            } else if (split[0].equals("8")) {
                if (!queue.isEmpty()) bw.write(queue.peekLast() + "\n");
                else bw.write(-1 + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

}