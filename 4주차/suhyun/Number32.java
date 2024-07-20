import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> used = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        int right = 0;

        for (char c : s.toCharArray()) {
            // 포인터 안쪽에 있는 경우에만 업데이트 포인터보다 바깥쪽에 있는 경우는 이미 이전 문자라 무시해야함
            if (used.containsKey(c) && left <= used.get(c)) {
                left = used.get(c) + 1;
            } else {
                // 등장했던 문자가 아니라면 최대 문자의 길이를 업데이트
                maxLength = Math.max(maxLength, right - left + 1);
            }
            used.put(c, right);
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLongestSubstring("tmmzuxt");

    }
}
