class Solution {
    // 재귀 브루트포스
//    public int fib(int n) {
//        if (n <= 1) {
//            return n;
//        } else {
//            return fib(n - 1) + fib(n - 2);
//        }
//    }
    // 메모이제이션
    int[] dp = new int[31];
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        // 미리 계산해서 dp에 넣어두고 바로 가져옴
        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = fib(n - 1) + fib(n - 2);
        return dp[n];
    }
    // 타뷸레이션
//    public int fib(int n) {
//        int[] dp = new int[31];
//
//        // 얘는 걍 if (n <= 1) 값 미리 지정해두고, 2부터 for돌려서 풀기.
//        dp[0] = 0;
//        dp[1] = 1;
//
//        for (int i = 2; i <= n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[n];
//    }
    // 변수 2개로
//    public int fib(int n) {
//        int x = 0, y = 1;
//        for (int i = 0; i < n; i++) {
//            int z = x + y;
//            x = y;
//            y = z;
//        }
//        return x;
//    }
}
