import java.util.Arrays;

class Solution {
    // array, greedy, sorting, counting sort
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int len = nums.length / 2;
        // 1234
        // 122566
        for (int i = 0; i < len; i++) {
            sum += nums[2 * i];
        }
        return sum;
    }

    public int arrayPairSum2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        int[] counts = new int[max - min + 1];
        for (int num : nums) {
            counts[num - min]++;
        }
        int res = 0;
        int idx = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            while (counts[idx] == 0) {
                idx++;
            }
            res += idx;
            counts[idx]--;
            while (counts[idx] == 0) {
                idx++;
            }
            counts[idx]--;
        }
        return res + nums.length / 2 * min;
    }
}