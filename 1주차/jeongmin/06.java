class Solution {
    int left,maxLen=0;

    public void expand(String s,int j,int k) {
        //양끝이 같으면 확장
        while(j>=0 && k<s.length() &&s.charAt(j)==s.charAt(k)){
            j--;
            k++;
        }
        if(maxLen<k-j-1){
            left=j+1;
            maxLen=k-j-1;
        }
    }
    public String longestPalindrome(String s){
        int len=s.length();
        //입력받은 문자가 2개 이하면 문자 그대로 출력
        if(len<2){
            return s;
        }
        for(int i=0;i<len-1;i++){
            expand(s,i,i+1);
            expand(s,i,i+2);
        }
        return s.substring(left,left+maxLen);
    }
}