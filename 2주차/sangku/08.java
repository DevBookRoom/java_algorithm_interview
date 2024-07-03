class Solution {
    public int trap(int[] height) {
        // 동일 높이 투포인터 활용
        int left = 0;
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];

        int volume = 0;

        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            if (leftMax <= rightMax) {
                volume += leftMax - height[left];
                left++;
            } else {
                volume += rightMax - height[right];
                right--;
            }

        }
        return volume;
    }

    // stack 활용 해보기
    // arraydequeue, stack
}