import java.io.*;
import java.util.*;

public class Main {
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cnt = 0;
            st.nextToken();
            int[] line = new int[20];
            for (int j = 0; j < 20; j++) {
                line[j] = Integer.parseInt(st.nextToken());
            }
            sort(line);
            bw.write(i + " " + cnt + "\n");

        }
        bw.flush();
        bw.close();
    }

    public static void sort(int[] line) {
        int criteria = 0;
        while (criteria < 20) {
            for (int i = 0; i < criteria; i++) {
                if (line[criteria] < line[i]) {
                    cnt += (criteria - i);
                    int tmp = line[criteria];
                    for (int j = criteria; j > i; j--) {
                        line[j] = line[j - 1];
                    }
                    line[i] = tmp;
                    break;
                }
            }
            criteria++;
        }
    }
}