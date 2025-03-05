import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] line = new int[N];
        int order = 1;
        for (int l = 0; l < line.length; l++) {
            line[l] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty()) {
                if (stack.peek() != order) {
                    break;
                } else {
                    stack.pop();
                    order++;
                }
            }
            if (line[i] != order) {
                stack.push(line[i]);
            } else {
                order++;
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() != order) {
                System.out.println("Sad");
                break;
            } else {
                stack.pop();
                order++;
            }
        }
        if(stack.isEmpty()) {
            System.out.println("Nice");
        }
    }
}