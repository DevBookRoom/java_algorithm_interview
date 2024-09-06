
class Solution {
    public int rob(int[] nums) {

        if(n<0)return 0;

        return Math.max(
                rob(nums,n-1),
                rob(nums,n-2)+nums[n]
        );
    }

    public int rob(int[]nums){
        return rob(nums,nums.length-1);
    }
}