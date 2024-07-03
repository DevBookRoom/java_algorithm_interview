public class Number8 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
    }
}

class Solution {
    public int trap(int[] height) {

        // 어짜피 큰 벽 기준 작은 거는 다 채워진다.
        int result = 0;

        int left = 0;
        int right = height.length - 1;

        // 좌측 기준 최대 높이
        int leftMax = height[left];
        // 우측 기준 최대 높이
        int rightMax = height[right];

        while (left < right) {
            // 최댓값 세팅
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            // 우측이 최대 높이가 더 큰 경우
            if (leftMax < rightMax) {
                // 왼쪽 최대 높이에서 현재 높이 뺀 만큼 물이 찬다
                result += leftMax - height[left];
                left += 1;
            } else {
                result += rightMax - height[right];
                right -= 1;
            }
        }

        return result;

    }
}