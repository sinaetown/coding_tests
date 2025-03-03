import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i * i <= N; i++) {
            cnt++;
        }
        System.out.println(cnt);
    }
}