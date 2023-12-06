import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("push")) {
                int push_int = Integer.parseInt(st.nextToken());
                queue.add(push_int);
            } else { //front, back, size, empty, pop
                if (order.equals("front")) {
                    if (!queue.isEmpty()) {
                        l.add(queue.getFirst());
                    } else {
                        l.add(-1);
                    }
                } else if (order.equals("back")) {
                    if (!queue.isEmpty()) {
                        l.add(queue.getLast());
                    } else {
                        l.add(-1);
                    }
                } else if (order.equals("size")) {
                    l.add(queue.size());
                } else if (order.equals("empty")) {
                    if (queue.isEmpty()) {
                        l.add(1);
                    } else {
                        l.add(0);
                    }
                } else if (order.equals("pop")) {
                    if (!queue.isEmpty()) {
                        l.add(queue.poll());
                    } else {
                        l.add(-1);
                    }
                }
            }
        }
        for(int k = 0; k < l.size(); k++){
            System.out.println(l.get(k));
        }
    }
}
