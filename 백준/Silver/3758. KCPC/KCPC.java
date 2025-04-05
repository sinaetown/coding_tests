import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    public static class Element {
        int submissions;
        int score;
        int time;
        int team;

        public Element(int submissions, int score, int time, int team) {
            this.submissions = submissions;
            this.score = score;
            this.time = time;
            this.team = team;
        }
    }

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcases = Integer.parseInt(br.readLine());
        int[][] arr;
        Map<Integer, Integer> submission = new HashMap<>();
        for (int z = 0; z < testcases; z++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); //팀 개수
            int k = Integer.parseInt(st.nextToken()); //문제의 개수
            int t = Integer.parseInt(st.nextToken()); //내 팀의 ID
            int m = Integer.parseInt(st.nextToken()); //로그 엔트리 개수
            //팀ID, 문제번호 = 점수
            arr = new int[n + 1][k + 1];
            //팀ID = 시간
            int[] time = new int[n + 1];
            submission = new HashMap<>();
            for (int q = 0; q < m; q++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken()); //팀 ID
                int j = Integer.parseInt(st.nextToken()); //문제 번호
                int s = Integer.parseInt(st.nextToken()); //획득한 점수
                if (arr[i][j] < s) {
                    arr[i][j] = s;
                }
                time[i] = q;
                submission.put(i, submission.getOrDefault(i, 0) + 1);

            }
//            System.out.println(Arrays.deepToString(arr));
//            System.out.println(submission);

            bw.write(inOrder(arr, submission, time, t) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int inOrder(int[][] arr, Map<Integer, Integer> submission, int[] time, int myTeam) {
        List<Element> list = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> it = submission.entrySet().iterator();
        int index = 1;
        for (int a = 1; a < arr.length; a++) {
            int total = 0;
            for (int b = 1; b < arr[a].length; b++) {
                total += arr[a][b];
            }
            list.add(new Element(it.next().getValue(), total, time[a], index++));
        }
        list.sort(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if ((o1.score == o2.score) && (o1.submissions == o2.submissions)) return o1.time - o2.time;
                else if (o1.score == o2.score) return o1.submissions - o2.submissions;
                return o2.score - o1.score;
            }
        });
//        for (Element e : list) {
//            System.out.println(e.team + " " + e.score + " " + e.submissions + " " + e.time);
//        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).team == myTeam) {
//                System.out.println("here: " + list.get(i).team);
                return i + 1;
            }
        }
        return -1;
    }
}
