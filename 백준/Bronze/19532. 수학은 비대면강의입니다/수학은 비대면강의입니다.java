import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        int x = 0;
        int y = 0;
        if (a == 0) {
            y = c / b;
            x = (f - e * y) / d;
        } else if (d == 0) {
            y = f / e;
            x = (c - b * y) / a;
        } else if (b == 0) {
            x = c / a;
            y = (f - d * x) / e;
        } else if (e == 0) {
            x = f / d;
            y = (c - a * x) / b;
        } else if (a != 0 && b != 0 && c != 0 && d != 0) {
            y = (c * d - f * a) / (b * d - e * a);
            x = (c - b * y) / a;
        }
        System.out.println(x + " " + y);
    }
}