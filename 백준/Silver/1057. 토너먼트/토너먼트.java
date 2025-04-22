import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int lim = Integer.parseInt(st.nextToken());
        int answer = 1;
        while (!isDone(kim, lim)) {
            answer++;
            if (kim % 2 == 1) kim = (kim + 1) / 2;
            else kim /= 2;
            if (lim % 2 == 1) lim = (lim + 1) / 2;
            else lim /= 2;
        }
        System.out.println(answer);
    }

    public static boolean isDone(int kim, int lim) {
        if (lim > kim) {
            if (Math.abs(lim - kim) == 1 && lim % 2 == 0) return true;
        } else {
            if (Math.abs(lim - kim) == 1 && kim % 2 == 0) return true;
        }
        return false;
    }
}