import java.util.Arrays;

class Solution {
    // min(a, b) 형식의 합으로 최대의 수를 구하려면, 그냥 페어에 숫자를 순서대로 두개씩 넣으면 된다.
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;

        for (int i = 0; i < nums.length; i += 2) {
            ans += nums[i];
        }

        return ans;
    }
}
