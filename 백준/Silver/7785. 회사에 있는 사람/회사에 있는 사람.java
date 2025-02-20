import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeSet<String> total = new TreeSet<>();
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String employee = st.nextToken();
            if (!total.contains(employee)) {
                total.add(employee);
            } else {
                total.remove(employee);
            }
        }
        Iterator<String> iterator = total.descendingIterator();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 0;
        while (iterator.hasNext()) {
            if (count != total.size() - 1) {
                bw.write(iterator.next() + "\n");
                count++;
            } else {
                bw.write(iterator.next());
            }
        }
        bw.flush();
        bw.close();
    }
}