class Solution {
    public boolean isPalindrome(String s) {
        boolean flag=true;
        //1. replaceAll을 사용해 정규식을 이용해 영숫자가 아닌 경우 ""로 변경 , 소문자로 변경
        String ans=s.toLowerCase().replaceAll("[^a-z0-9]", "");

        for(int i=0;i<ans.length()/2;i++){
        //2. 한문자씩 비교
            char start=ans.charAt(i);
            char end=ans.charAt(ans.length()-(i+1));
            if(start!=end) {
                flag = false;
                break;
            }
        }
        return flag;

    }

}