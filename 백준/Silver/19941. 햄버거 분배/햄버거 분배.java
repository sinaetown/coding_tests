import java.io.*;
import java.util.*;

public class Main {
    static int[] line;
    static int K;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        line = new int[N];
        int count = 0;
        String read = br.readLine();
        for (int i = 0; i < N; i++) {
            if (read.charAt(i) == 'H') {
                line[i] = 1; //햄버거
            } else line[i] = 2; //사람
        }
        for (int i = 0; i < N; i++) {
            boolean flag = false;
            if (line[i] == 2) {
                for (int j = K; j > 0; j--) {
                    if (i - j >= 0) {
                        if (line[i -
                                j] == 1) {
                            count++;
                            line[i - j] = 3; //먹은 햄버거
                            flag = true;
                            break;
                        }
                    }

                }
                if (!flag) {
                    for (int j = 1; j <= K; j++) {
                        if (i + j < N) {
                            if (line[i + j] == 1) {
                                count++;
                                line[i + j] = 3;
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}