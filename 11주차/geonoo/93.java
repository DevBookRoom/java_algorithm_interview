class Solution {
    // 메모이제이션
    int[] dp = new int[46];
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = climbStairs(n - 1) + climbStairs(n - 2);
        return dp[n];
    }
    // 재귀 브로트 포스
//    public int climbStairs(int n) {
//        if (n <= 2) {
//            return n;
//        }
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }
}
