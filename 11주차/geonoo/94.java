class Solution {
    // DP
    public int rob(int[] nums) {
        // 제약조건 : 1 <= nums.length <= 100 -> 배열 길이 1이면 바로 리턴
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];

        // DP -> 타뷸레이션
        dp[0] = nums[0];    // 첫 번째 집을 털었을 때 금액
        dp[1] = Math.max(nums[0], nums[1]); // 두 번째 집까지의 최대 금액

        // 나머지 집들 최대 금액 계산 (이전 결과와 전전+현재 결과 중 더 큰 값) 한 칸 띄워서 계산해야 하니까!
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        // 마지막 값을 리턴 (최댓값)
        return dp[nums.length - 1];
    }
    // 재귀 브루트포스
//    public int rob(int[] nums) {
//        return rob(nums, nums.length - 1);
//    }
//
//    public int rob(int[] nums, int n) {
//        if (n < 0) {
//            return 0;
//        }
//
//        // 이전 결과
//        return Math.max(rob(nums, n - 1), rob(nums, n - 2) + nums[n]);
//    }
}
