class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int p = 1;
        for (int i=0; i<nums.length; i++) {
            answer[i] = p;
            p *= nums[i];
        }

        for (int i= nums.length-1; i>=0; i--) {
            answer[i] *= p;
            p *= nums[i];
        }
        return answer;
    }
}