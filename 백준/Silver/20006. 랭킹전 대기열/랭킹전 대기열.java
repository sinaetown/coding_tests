import java.io.*;
import java.util.*;

public class Main {

    public static class Room {
        int cnt;
        int min;
        int max;
        List<String> members;

        public Room(int cnt, int min, int max, List<String> members) {
            this.cnt = cnt;
            this.min = min;
            this.max = max;
            this.members = members;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken()); //플레이어 수
        int m = Integer.parseInt(st.nextToken()); //방의 정원
        List<Room> list = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            String members = br.readLine();
            st = new StringTokenizer(members);
            int l = Integer.parseInt(st.nextToken()); //레벨
            String n = st.nextToken(); //닉네임
            boolean flag = false;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).min <= l && list.get(j).max >= l && list.get(j).cnt + 1 <= m) {
                    list.get(j).cnt++;
                    list.get(j).members.add(members);
                    flag = true;
                    break;
                }
            }
            if (list.isEmpty() || !flag) {
                List<String> stringList = new ArrayList<>();
                stringList.add(members);
                list.add(new Room(1, l - 10, l + 10, stringList));
            }
        }
        int ind = 0;
        for (Room r : list) {
            r.members.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String s1 = o1.split(" ")[1];
                    String s2 = o2.split(" ")[1];
                    return s1.compareTo(s2);
                }
            });
        }
        for (Room r : list) {
            if (r.members.size() == m) {
                bw.write("Started!" + "\n");
            } else {
                bw.write("Waiting!" + "\n");
            }
            for (String s : r.members) {
                bw.write(s + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
