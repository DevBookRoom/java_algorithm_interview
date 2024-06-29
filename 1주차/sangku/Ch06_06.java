public class Ch06_06 {

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        for (int windowSize = s.length(); windowSize > 1; windowSize--) {
            for (int i = 0; i <= s.length() - windowSize; i++) {
                if (isPalindrome(s, i, i + windowSize - 1)) {
                    return s.substring(i, i + windowSize);
                }
            }
        }
        return s.substring(0, 1);
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}

/*
class Solution {
    int start=0;
    int end=0;

    public String longestPalindrome(String s) {
        char arr[]=s.toCharArray();
        getpalindrome(arr,0);
        return s.substring(start,end+1);
    }

    public void getpalindrome(char arr[],int i){
        int left=i;
        int right=i;
        int n=arr.length;
        if(i>=n-1){
            return;
        }

        while(right<n-1&&arr[right]==arr[right+1]){
            right++;
        }
        i=right;
        while(left>0&&right<n-1&&arr[left-1]==arr[right+1]){
            left--;
            right++;
        }
        if(right-left>end-start){
            start=left;
            end=right;
        }
        getpalindrome(arr,i+1);
    }
}
* */