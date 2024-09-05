class Solution {
    public int solution(int[] money) {
        int n = money.length;

        // 첫 번째 집을 터는 경우는 배열의 첫 번째 요소부터 마지막에서 두 번째 요소까지 고려.
        int[] dp1 = new int[n];
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);
        }

        // 첫 번째 집을 털지 않는 경우는 배열의 두 번째 요소부터 마지막 요소까지 고려.
        int[] dp2 = new int[n];
        dp2[1] = money[1];
        dp1[1] = Math.max(money[0], money[1]);
        for (int i = 2; i < n; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);
        }

        // 가장 마지막 값 가져와서 최댓값 비교
        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}
