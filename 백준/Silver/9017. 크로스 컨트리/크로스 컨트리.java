import java.io.*;
import java.util.*;


public class Main {

    public static class Info {
        int team;
        int score;

        public Info(int team, int score) {
            this.team = team;
            this.score = score;
        }
    }

    public static boolean[] six;
    public static List<Info> list;
    public static List<int[]> compare;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            list = new ArrayList<>();
            compare = new ArrayList<>();
            int maxTeam = 0;
            for (int n = 0; n < N; n++) {
                int team = Integer.parseInt(st.nextToken());
                maxTeam = Math.max(team, maxTeam);
                arr[n] = team;
            }
            six = new boolean[maxTeam + 1];
            valid(maxTeam, arr);
            int index = 1;
            for (int i = 0; i < arr.length; i++) {
                if (six[arr[i]]) {
                    list.add(new Info(arr[i], index++));
                } else {
                    list.add(new Info(arr[i], 0));
                }
            }
            for (int i = 0; i < six.length; i++) {
                if (six[i]) {
                    compare.add(cal(i));
                }
            }
            compare.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1]) return o1[2] - o2[2];
                    return o1[1] - o2[1];
                }
            });
            bw.write(compare.get(0)[0] + "\n");
        }
        bw.flush();
    }

    public static int[] cal(int target) {
        int sum = 0;
        int five = 0;
        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).team == target) {
                cnt++;
                if (cnt <= 4) sum += list.get(i).score;
                if (cnt == 5) five = list.get(i).score;
            }
        }
        return new int[]{target, sum, five};
    }

    public static void valid(int maxTeam, int[] arr) {
        int[] cnt = new int[maxTeam + 1];
        for (int i = 0; i < arr.length; i++) {
            cnt[arr[i]]++;
        }
        for (int c = 0; c < cnt.length; c++) {
            if (cnt[c] == 6) six[c] = true;
        }
    }
}