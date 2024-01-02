import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        String answer = "";
        while (N > 1) {
            if (N % B >= 10) {
                answer = (char) ((N % B) + 55) + answer;
            } else {
                answer = (N % B) + answer;
            }
            N /= B;
        }
        if (N != 0) {
            answer = N + answer;
        }
        System.out.println(answer);

    }
}
