class Solution {
    public boolean check(int[]data,int start,int size){
        for(int i=start+1;i<start+size+1;i++) {
            if (i>=data.length || data[i] >> 6 != 0b10){
                return false;
            }
        }
        return true;
    }
    public boolean validUtf8(int[] data) {
        int start=0;
        while(start<data.length){
            int first=data[start];
            //111100으로 시작하면 나머지가 3비트여야한다.
            if(first>>3==0b11110&&check(data,start,3)){
                start+=4;
                //1110xxxx 패턴으로 시작하는지 확인/ 나머지가 2비트여야함
            }else if(first>>4 ==0b1110&&check(data,start,2)){
                start+=3;
                //110xxxx 패턴으로 시작하는지 확인/ 나머지가 1비트여야함
            }else if(first>>5==0b110&&check(data,start,1)){
                start+=2;
                //0xxxxxxx 패턴으로 시작하는지 확인/ 1바이트 문자
            }else if(first>>7==0){
                start++;
            }else {
                return false;
            }
        }
        return true;


    }
}