import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> l = new ArrayList<>();

        String s = "";
        while ((s=br.readLine())!=null) {
            StringTokenizer st = new StringTokenizer(s);
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            l.add(A + B);
        }
        for (int ll : l) {
            System.out.println(ll);
        }

    }

}
