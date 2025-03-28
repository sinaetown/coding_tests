import java.io.*;
import java.util.*;

public class Main {

    public static class Person {
        int weight;
        int height;

        public Person(int w, int h) {
            this.weight = w;
            this.height = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            list.add(new Person(w, h));
        }
        for (int i = 0; i < list.size(); i++) {
            int cnt = 0;
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                if (list.get(i).weight < list.get(j).weight
                        && list.get(i).height < list.get(j).height) cnt++;
            }
            bw.write(cnt + 1 + " ");
        }
        bw.flush();
        bw.close();

    }


}