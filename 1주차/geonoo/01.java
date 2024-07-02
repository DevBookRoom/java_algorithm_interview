class Solution {
    public boolean isPalindrome(String s) {

        // 인덱싱을 위한 변수
        int left = 0;
        int right = s.length() -1;

        while (left < right) {
            // isLetterOrDigit -> 특수문자 거르기
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;

                // toLowerCase -> 대소문자 상관 x
            } else {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}