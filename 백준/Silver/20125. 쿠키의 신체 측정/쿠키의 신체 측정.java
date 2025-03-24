import javax.crypto.spec.PSource;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[][] grid = new String[N + 1][N + 1];
        boolean chk = false;
        int[] head = new int[2];
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= N; j++) {
                grid[i][j] = line.substring(j - 1, j);
                if (!chk && line.substring(j - 1, j).equals("*")) {
                    chk = true;
                    head = new int[]{i, j};
                }

            }
        }
        bw.write(head[0] + 1 + " " + head[1] + "\n");
        int[] heart = new int[]{head[0] + 1, head[1]};

        int left_arm = 0;
        for (int y = 1; y < heart[1]; y++) {
            if (grid[heart[0]][y].equals("*")) left_arm++;
        }
        bw.write(left_arm + " ");

        int right_arm = 0;
        for (int y = heart[1] + 1; y <= N; y++) {
            if (grid[heart[0]][y].equals("*")) right_arm++;
        }
        bw.write(right_arm + " ");

        int waist = 0;
        for (int x = heart[0] + 1; x <= N; x++) {
            if (grid[x][heart[1]].equals("*")) waist++;
            else break;
        }
        bw.write(waist + " ");

        int right_leg = 0;
        for (int x = heart[0] + waist + 1; x <= N; x++) {
            if (grid[x][heart[1] - 1].equals("*")) right_leg++;
            else break;
        }

        int left_leg = 0;
        for (int x = heart[0] + waist + 1; x <= N; x++) {
            if (grid[x][heart[1] + 1].equals("*")) left_leg++;
            else break;
        }

        bw.write(right_leg + " ");
        bw.write(left_leg + " ");
        bw.flush();
        bw.close();

    }
}
