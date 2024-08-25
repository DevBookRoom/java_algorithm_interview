class Solution {
    public boolean contains(String str,String t){
        StringBuilder sb=new StringBuilder(str);

        for(char elem:t.toCharArray()){
            if(sb.indexOf(String.valueOf(elem))!=-1)
                sb.deleteCharAt(sb.indexOf(String.valueOf(elem)));
            else return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        for(int windowSize=t.length();windowSize<s.length()+1;windowSize++){
            for(int left=0;left<s.length()-windowSize+1;left++){
                String str=s.substring(left,left+windowSize);

                if(contains(str,t))return str;
            }
        }
        return "";
    }
}