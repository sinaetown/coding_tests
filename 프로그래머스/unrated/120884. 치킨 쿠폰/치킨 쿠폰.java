class Solution {
    public int solution(int chicken) {
        int total = 0;
        int coupon = chicken;
        int left_chick = 0;
        while (coupon>9) {
            left_chick=coupon/10;
            coupon = coupon-10*left_chick+left_chick;
            total+=left_chick;
        }

        return total;
    }
}