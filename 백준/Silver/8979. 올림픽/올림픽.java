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
        }

        public Country(int number, int sorted) {
            this.number = number;
            this.sorted = sorted;
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

        int answer = 1;
        List<Country> sorted = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int cnt = 0;
            if (i == list.size() - 1) {
                sorted.add(new Country(list.get(i).number, answer));
                break;
            }
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).gold == list.get(j).gold
                        && list.get(i).silver == list.get(j).silver
                        && list.get(i).bronze == list.get(j).bronze) {
                    cnt++;
                    sorted.add(new Country(list.get(j).number, answer));
                } else {
                    sorted.add(new Country(list.get(i).number, answer));
                    if (cnt == 0) answer++;
                    else {
                        answer += cnt + 1;
                        i += cnt;
                    }
                    break;
                }
            }
        }
        for (Country c : sorted) {
            if (c.number == target) {
                System.out.println(c.sorted);
            }
        }

    }
}