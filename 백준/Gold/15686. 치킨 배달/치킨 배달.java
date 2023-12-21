import java.io.*;
import java.util.*;

public class Main {
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Integer>> chicken = new ArrayList<>();
        List<List<Integer>> house = new ArrayList<>();
        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int in = Integer.parseInt(st.nextToken());
                matrix[i][j] = in;
                if (in == 1) {
                    house.add(Arrays.asList(i, j));
                } else if (in == 2) {
                    chicken.add(Arrays.asList(i, j));
                }
            }
        }
//        System.out.println(Arrays.toString(matrix[1]));
//        System.out.println("house :" + house);
//        System.out.println("chicken: " + chicken);
        List<List<List<Integer>>> removalChicken = new ArrayList<>();
        List<List<Integer>> temp = new ArrayList<>();
        combination(chicken, removalChicken, 0, temp, M);

        int distance = 0;
        int min = Integer.MAX_VALUE;
        Queue<Integer> pq = new PriorityQueue<>();
//        System.out.println(removalChicken);
        for (int i = 0; i < removalChicken.size(); i++) {
            for (int j = 0; j < house.size(); j++) {
                for (int k = 0; k < M; k++) {
//                    System.out.println("chicken: " + removalChicken.get(i).get(k) + "house: " + house.get(j)
//                            + (Math.abs(removalChicken.get(i).get(k).get(0) - house.get(j).get(0))
//                            + Math.abs(removalChicken.get(i).get(k).get(1) - house.get(j).get(1))));
                    min = Math.min(
                            (Math.abs(removalChicken.get(i).get(k).get(0) - house.get(j).get(0))
                                    + Math.abs(removalChicken.get(i).get(k).get(1) - house.get(j).get(1))),
                            min);
//                    System.out.println(min);
                }
                distance += min;
                min = Integer.MAX_VALUE;
            }
            pq.add(distance);
            distance=0;
        }
        System.out.println(pq.poll());
    }


    static public void combination(List<List<Integer>> chicken, List<List<List<Integer>>> removalChicken, int start,
                                   List<List<Integer>> temp, int limit) {
        if (limit == temp.size()) {
            removalChicken.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            temp.add(chicken.get(i));
            combination(chicken, removalChicken, i + 1, temp, limit);
            temp.remove(temp.size() - 1);
        }
    }
}
