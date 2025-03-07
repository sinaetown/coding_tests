import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] a = new int[N];
        int[] b = new int[M];
        for (int n = 0; n < N; n++) {
            a[n] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
            b[m] = Integer.parseInt(st.nextToken());
        }
        int aPtr = 0;
        int bPtr = 0;
        while (true) {
            if (aPtr == N && bPtr == M) break;
            else if (aPtr == N) {
                bw.write(b[bPtr] + " ");
                bPtr++;
            } else if (bPtr == M) {
                bw.write(a[aPtr] + " ");
                aPtr++;
            } else if (a[aPtr] < b[bPtr]) {
                bw.write(a[aPtr] + " ");
                aPtr++;
            } else if (a[aPtr] >= b[bPtr]) {
                bw.write(b[bPtr] + " ");
                bPtr++;
            }
        }
        bw.flush();
        bw.close();
    }


}