class Solution {
  /*    1. start,end변수를 선언하여 각각배열의 시작과 끝 인덱스를 가리키도록한다.
        2. start,end의 인덱스에 위치하는 문자를 서로 바꾼다.
        3. start는 배열의 마지막쪽으로(증가),end는 배열의 시작쪽으로 이동(감소)시킨다.
   */
    public void reverseString(char[] s) {
        int start=0;
        int end=s.length-1;
        while(start<end){
            char tmp=s[start];
            s[start]=s[end];
            s[end]=tmp;
            start++;
            end--;
        }

    }
}