public class Solution {
    public int maxProfit(int[] prices) {
        // 가장 큰 값으로 최소가격 초기화
        int minPrice = Integer.MAX_VALUE;
        // 가장 작은 값으로 최대이익 초기화
        int maxProfit = 0;

        for (int price : prices) {
            // 현재 가격과 비교
            if (price < minPrice) {
                minPrice = price;

                // 최대 이익 계산
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}
