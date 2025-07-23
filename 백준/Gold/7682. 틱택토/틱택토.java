import java.io.*;
import java.util.*;

public class Main {
    public static char[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String line = br.readLine();
            if (line.equals("end")) break;
            int index = 0;
            grid = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    grid[i][j] = line.charAt(index++);
                }
            }
            if (chk()) bw.write("valid\n");
            if (!chk()) bw.write("invalid\n");
        }
        bw.flush();
    }

    public static boolean chk() {
        int[] counts = cnt();
        int o = counts[0];
        int x = counts[1];
        if (tic('X') && tic('O')) return false;
        if (!tic('X') && !tic('O') && x == 5 && o == 4) return true; // 다 차있을 경우
        if (tic('O') && o == x) return true; // O가 틱택토
        if (tic('X') && x == o + 1) return true; //X가 틱택토
        return false;
    }

    public static boolean tic(char c) {
        //가로 체크
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][2] == c) return true;
        }
        //세로 체크
        for (int i = 0; i < 3; i++) {
            if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[2][i] == c) return true;
        }
        //대각선 체크
        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[2][2] == c) return true;
        if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[2][0] == c) return true;
        return false;
    }

    public static int[] cnt() {
        int x = 0;
        int o = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 'O') o++;
                if (grid[i][j] == 'X') x++;
            }
        }
        return new int[]{o, x};
    }
}