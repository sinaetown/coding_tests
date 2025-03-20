import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> time = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            time.add(Integer.parseInt(st.nextToken()));
        }
        time.sort(null);
        int sum = 0;
        int answer = 0;
        for (int t : time) {
            sum += t;
            answer += sum;
        }
        System.out.println(answer);
    }
}

