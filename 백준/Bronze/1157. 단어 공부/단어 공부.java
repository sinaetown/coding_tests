import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            map.put(Character.toLowerCase(word.charAt(i)), map.getOrDefault(Character.toLowerCase(word.charAt(i)), 0) + 1);
        }

        int max = 0;
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1); //max pq
        pq.addAll(map.values());
        if (pq.size() == 1) {
            System.out.println(Character.toUpperCase(word.charAt(0)));
            return;
        }
        int polled = pq.poll(); //get max int

        if (polled == pq.peek()) { //if if there's another element as the max value
            System.out.println("?");
        } else {
            for (Map.Entry<Character, Integer> e : map.entrySet()) {
                if (polled == e.getValue()) {
                    System.out.println(Character.toUpperCase(e.getKey()));
                    return;
                }
            }
        }
    }
}