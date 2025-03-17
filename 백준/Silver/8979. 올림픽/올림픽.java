import java.io.*;
import java.util.*;

public class Main {

    public static class Country {
        int number;
        int gold;
        int silver;
        int bronze;
        int sorted;

        public Country(int number, int gold, int silver, int bronze) {
            this.number = number;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.sorted = 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<Country> list = new ArrayList<>();
        int target = Integer.parseInt(st.nextToken());
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            list.add(new Country(number, gold, silver, bronze));
        }
        Collections.sort(list, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                if (o1.gold == o2.gold && o1.silver == o2.silver) {
                    return o2.bronze - o1.bronze;
                } else if (o1.gold == o2.gold) {
                    return o2.silver - o1.silver;
                } else return o2.gold - o1.gold;
            }
            ;
        });

        for (int i = 1; i < N; i++) {
            Country c1 = list.get(i - 1);
            Country c2 = list.get(i);
            if (c1.gold == c2.gold
                    && c1.silver == c2.silver
                    && c1.bronze == c2.bronze) {
                c2.sorted = c1.sorted;
            } else {
                c2.sorted = i + 1;
            }
        }

        for (Country c : list) {
            if (c.number == target) {
                System.out.println(c.sorted);
            }
        }
    }
}