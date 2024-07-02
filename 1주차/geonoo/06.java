class Solution {
    public String longestPalindrome(String s) {
        // 인덱싱을 위한 변수
        int left = 0, right = 0;

        for (int i = 0; i < s.length(); i++) {
            // 홀수 길이 팰린드롬
            int len1 = expandCenter(s, i, i);
            // 짝수 길이 팰린드롬
            int len2 = expandCenter(s, i, i +1);
            // 둘 중 최대 길이 선택
            int len = Math.max(len1, len2);
            // 길이가 더 길 경우 인덱스 업데이트
            if (len > right - left) {
                left = i - (len -1) / 2;
                right = i + len / 2;
            }
        }
        // 가장 긴 팰린드롬 리턴
        return s.substring(left, right +1);
    }

    private int expandCenter(String s, int left, int right) {
        // left와 right 인덱스가 모두 범위 내에 있어야 하며, 팰린드롬이어야 함.
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // 조건 만족 시 범위 확장
            left--;
            right++;
        }
        // 확장 후 길이 반환
        return right - left -1;
    }
}
