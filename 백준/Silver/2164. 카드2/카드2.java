import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = n; i > 0; i--) {
            deque.push(i);
        }
        int j = 0;
        while (deque.size() > 1) {
            if (j % 2 == 0) {
                deque.removeFirst();
            } else {
                int under = deque.pop();
                deque.addLast(under);
            }
            j++;
        }
        System.out.println(deque.pop());
    }
}