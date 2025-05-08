import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static int n;
    static List<List<List<Integer>>> all;
    static double max = Double.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            List<Integer> l = new ArrayList<>();
            l.add(x);
            l.add(y);
            list.add(l);
        }
        all = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            boolean[] visited = new boolean[n];
            List<List<Integer>> sub = new ArrayList<>();
            getThree(i, visited, sub);
        }
        cal();
        System.out.println(max);
    }

    public static void cal() {
        for (int a = 0; a < all.size(); a++) {
            List<List<Integer>> points = all.get(a);
            int x1 = points.get(0).get(0);
            int y1 = points.get(0).get(1);
            int x2 = points.get(1).get(0);
            int y2 = points.get(1).get(1);
            int x3 = points.get(2).get(0);
            int y3 = points.get(2).get(1);
            int first = (x1 * y2 + x2 * y3 + x3 * y1);
            int second = (x2 * y1 + x3 * y2 + x1 * y3);
            double area = (double) (Math.abs(first - second)) / 2;
            if (area > max) max = area;
        }
    }

    public static void getThree(int start, boolean[] visited, List<List<Integer>> sub) {
        if (sub.size() == 3) {
            all.add(new ArrayList<>(sub));
            sub = new ArrayList<>();
            return;
        }
        for (int i = start; i < list.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                List<Integer> pair = new ArrayList<>();
                pair.add(list.get(i).get(0));
                pair.add(list.get(i).get(1));
                sub.add(pair);
                getThree(i + 1, visited, sub);
                visited[i] = false;
                sub.remove(sub.size() - 1);
            }
        }
    }

}