import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; n++) {
            int M = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();
                if (!map.containsKey(kind)) {
                    map.put(kind, 1);
                } else {
                    map.put(kind, map.get(kind) + 1);
                }
            }
            if (map.size() == 1) {
                Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
                Map.Entry<String, Integer> entry = iterator.next();
                bw.write(entry.getValue() + "\n");

            } else {
                Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
                int sum = 1;
                while (it.hasNext()) {
                    sum *= it.next().getValue() + 1;
                }
                bw.write((sum - 1) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}