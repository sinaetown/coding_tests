import java.util.*;

class Solution {
    public static class Car {
        public String num;
        public ArrayList<String> timeList;

        public Car(String num) {
            this.num = num;
            this.timeList = new ArrayList<>();
        }

        public String getNum() {
            return num;
        }

        public ArrayList<String> getTimeList() {
            return timeList;
        }
    }

    public static int[] solution(int[] fees, String[] records) {
        List<Integer> money = new ArrayList<>();
        List<Car> list = new ArrayList<>();
        List<String> numCarList = new ArrayList<>();
        for (String r : records) {
            String[] splitted = r.split(" ");
            if (!numCarList.contains(splitted[1])) {
                Car newlyAdded = new Car(splitted[1]);
                newlyAdded.getTimeList().add(splitted[0]);
                list.add(newlyAdded);
                numCarList.add(splitted[1]);
            } else {
                for (Car c : list) {
                    if (c.getNum().equals(splitted[1])) {
                        ArrayList<String> selected = c.getTimeList();
                        selected.add(splitted[0]);
                    }
                }
            }
        }
        list.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return Integer.parseInt(o1.getNum()) - Integer.parseInt(o2.getNum());
            }
        });

        for (Car c : list) {
            if (c.getTimeList().size() % 2 != 0) {
                c.getTimeList().add("23:59");
            }
            int totalMin = 0;
            for (int i = 0; i < c.getTimeList().size() - 1; i += 2) {
                totalMin += toMin(c.getTimeList().get(i), c.getTimeList().get(i + 1));
            }
            if (totalMin <= fees[0]) {
                money.add(fees[1]);
            } else {
                int extra = (totalMin - fees[0]) % fees[2] != 0 ? (int) Math.ceil((double) (totalMin - fees[0]) / fees[2]) : (totalMin - fees[0]) / fees[2];

                money.add(fees[1] + extra * fees[3]);
            }
        }

        int[] answer = new int[money.size()];
        int ind = 0;
        for (int i : money) answer[ind++] = i;
        return answer;
    }

    public static int toMin(String s1, String s2) {
        int total1 = 0;
        int total2 = 0;

        String[] splitted1 = s1.split(":");
        total1 = 60 * Integer.parseInt(splitted1[0]) + Integer.parseInt(splitted1[1]);

        String[] splitted2 = s2.split(":");
        total2 = 60 * Integer.parseInt(splitted2[0]) + Integer.parseInt(splitted2[1]);

        return total2 - total1;
    }
}