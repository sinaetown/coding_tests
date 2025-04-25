import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] visited = new int[n][n];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    visited[i][j] = 1;
                }
            }
        }
        fload(visited);
        print(visited);
    }

    public static void fload(int[][] visited) {
        for (int k = 0; k < visited.length; k++) {
            for (int i = 0; i < visited.length; i++) {
                for (int j = 0; j < visited.length; j++) {
                    if (visited[i][k] == 1 && visited[k][j] == 1) visited[i][j] = 1;
                }
            }
        }
    }

    public static void print(int[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited.length; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }
}