public class Number12 {

    public int maxProfit(int[] prices) {
        int result = 0;

        int tmp = prices[0];

        for (int price : prices) {
            if (price <= tmp) {
                tmp = price;
            }

            int subtract = price - tmp;
            if (subtract >= 0 && result <= subtract) {
                result = price - tmp;
            }
        }
        System.out.println(result);

        return result;
    }

}
