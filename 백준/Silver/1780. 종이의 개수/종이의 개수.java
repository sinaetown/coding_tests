import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] answer = new int[3];
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(0, 0, n);
        for (int i : answer) System.out.println(i);
    }

    public static void recur(int row, int col, int size) {
        if (chk(row, col, size)) {
            answer[grid[row][col] + 1]++;
            return;
        }
        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                recur(row + i * newSize, col + j * newSize, newSize);
            }
        }
    }

    public static boolean chk(int row, int col, int size) {
        int n = grid[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != n) return false;
            }
        }
        return true;
    }
}