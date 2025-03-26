import java.io.*;
import java.util.*;

public class Main {

    public static class Command {
        int index;
        int word;
        String line;

        public Command(int index, String line) {
            this.index = index;
            this.line = line;
        }

        public Command(int index, int word, String line) {
            this.index = index;
            this.word = word;
            this.line = line;
        }

    }

    static Map<Character, Command> map;
    static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int n = 0; n < N; n++) {
            String line = br.readLine();
            list.add(line);
            String[] cmd = line.split(" ");
            boolean assigned = false;
            if (cmd.length == 1) { //한 단어일 경우
                for (int j = 0; j < cmd[0].length(); j++) {
                    if (!set.contains(Character.toLowerCase(cmd[0].charAt(j)))) {//!map.containsKey(cmd[0].charAt(j))
                        map.put(cmd[0].charAt(j), new Command(j, line));
                        set.add(Character.toLowerCase(cmd[0].charAt(j)));
                        break;
                    }
                }
            } else { //두 단어 이상일 경우
                for (int i = 0; i < cmd.length; i++) { // 단어의 첫 글자 확인
                    if (!set.contains(Character.toLowerCase(cmd[i].charAt(0)))) {
                        map.put(cmd[i].charAt(0), new Command(0, i, line));
                        set.add(Character.toLowerCase(cmd[i].charAt(0)));
                        assigned = true;
                        break;
                    }
                }
                if (!assigned) {
                    l1:
                    for (int i = 0; i < cmd.length; i++) { // 다음 글자들 확인
                        for (int j = 1; j < cmd[i].length(); j++) {
                            if (!set.contains(Character.toLowerCase(cmd[i].charAt(j)))) {
                                map.put(cmd[i].charAt(j), new Command(j, i, line));
                                set.add(Character.toLowerCase(cmd[i].charAt(j)));
                                break l1;
                            }
                        }

                    }
                }
            }
        }
//        Iterator<Command> it = map.values().iterator();
//        while (it.hasNext()) {
//            Command c = it.next();
//
//            System.out.println(c.index+ ", "+c.word+", "+c.index);
//        }

        print();
    }

    public static void print() {
        for (String s : list) {
            String[] arr = s.split(" ");
            int size = arr.length;
            Iterator<Map.Entry<Character, Command>> entryIterator = map.entrySet().iterator();
            boolean b = false;
            while (entryIterator.hasNext()) {
                Map.Entry<Character, Command> entry = entryIterator.next();
                if (entry.getValue().line.equals(s)) {
                    Character key = entry.getKey();
                    if (size >= 2) {
                        int word_ind = entry.getValue().word;
                        int ind = entry.getValue().index;
                        StringBuilder sb = new StringBuilder();
                        for (int z = 0; z < arr.length; z++) {
                            if (z == word_ind) {
                                String l = arr[word_ind];
                                String newL = l.substring(0, ind) + "[" + key + "]" + l.substring(ind + 1);
                                arr[word_ind] = newL;
                            }
//                            else {
//                                sb.append(arr[z]+" ");
//                            }
                        }
                        System.out.println(String.join(" ",arr));
                    } else {
                        int ind = entry.getValue().index;
                        String newString = s.substring(0, ind) + "[" + key + "]" + s.substring(ind + 1);
                        System.out.println(newString);
                    }

                    b = true;
                }
            }
            if (!b) System.out.println(s);
        }

    }
}
