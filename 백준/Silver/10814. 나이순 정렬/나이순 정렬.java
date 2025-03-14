import java.io.*;
import java.util.*;

public class Main {

    public static class Profile {
        int age;
        int order;
        String name;

        public Profile(int age, int order, String name) {
            this.age = age;
            this.order = order;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Profile> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Profile(Integer.parseInt(st.nextToken()), i, st.nextToken()));
        }
        Collections.sort(list, new Comparator<Profile>() {
            @Override
            public int compare(Profile o1, Profile o2) {
                if (o1.age == o2.age) {
                    return o1.order - o2.order;
                }
                return o1.age - o2.age;
            }
        });
        for (Profile p : list) {
            bw.write(p.age + " " + p.name + "\n");
        }
        bw.flush();
        bw.close();
    }

}