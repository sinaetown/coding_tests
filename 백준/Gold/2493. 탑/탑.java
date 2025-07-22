import java.io.*;
import java.util.*;

public class Main {

    public static class Building {
        int height;
        int num;

        public Building(int height, int num) {
            this.height = height;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Building> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()) {
                bw.write("0 ");
                stack.push(new Building(height, i));
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        bw.write("0 ");
                        stack.push(new Building(height, i));
                        break;
                    }
                    Building peeked = stack.peek();
                    if (peeked.height > height) {
                        stack.push(new Building(height, i));
                        bw.write(peeked.num + " ");
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        bw.flush();
    }
}