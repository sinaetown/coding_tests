import java.io.*;
import java.util.*;

public class Main {

    static ArrayDeque<Balloon> queue;
    static int num;

    public static class Balloon {
        int order;
        int num;

        public Balloon(int order, int num) {
            this.order = order;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.addLast(new Balloon(i, Integer.parseInt(st.nextToken())));
        }
        Balloon initial = queue.removeFirst();
        num = initial.num;
        bw.write(initial.order + " ");
        while (!queue.isEmpty()) {
            move(num);
            Balloon tobe = queue.removeFirst();
            num = tobe.num;
            bw.write(tobe.order + " ");
        }
        bw.flush();
        bw.close();
    }

    public static void move(int num) {
        if (num < 0) { // 시계 반대방향 (뒤->앞)
            for (int i = 0; i < Math.abs(num); i++) {
                Balloon last = queue.removeLast();
                queue.addFirst(last);
            }
        } else { //시계 방향 (앞->뒤)
            for (int i = 0; i < num - 1; i++) {
                Balloon first = queue.removeFirst();
                queue.addLast(first);
            }
        }
    }

}