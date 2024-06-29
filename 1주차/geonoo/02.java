class Solution {
    public void reverseString(char[] s) {
        // 인덱싱을 위한 변수
        int left = 0;
        int right = s.length -1;

        // 스왑 로직
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}