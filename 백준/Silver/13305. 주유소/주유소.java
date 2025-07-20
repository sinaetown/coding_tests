import java.io.*;
import java.util.*;

public class Main {
    public static int[] road;
    public static int[] fuel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long answer = 0;
        int n = Integer.parseInt(br.readLine());
        road = new int[n - 1];
        fuel = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            fuel[i] = Integer.parseInt(st.nextToken());
        }
        dec();
        for (int i = 0; i < road.length; i++) answer += (long) road[i] * fuel[i];
        System.out.println(answer);
    }

    public static void dec() {
        for (int i = 0; i < fuel.length - 1; i++) {
            if (fuel[i] < fuel[i + 1]) {
                fuel[i + 1] = fuel[i];
            }
        }
    }
}