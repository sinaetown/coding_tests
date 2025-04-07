import java.io.*;
import java.util.*;

public class Main {
    public static class Person {
        String name;
        int num;

        public Person(String name, int num) {
            this.name = name;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Person> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            queue.add(new Person(name, num));
        }

        while (queue.size() != 1) {
            Person chooser = queue.remove();
            int passes = chooser.num;
            for (int p = 0; p < passes - 1; p++) {
                Person candidate = queue.remove();
                queue.add(candidate);
            }
            queue.remove();
        }
        System.out.println(queue.remove().name);

    }
}