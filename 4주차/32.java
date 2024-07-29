
class Solution {
    public int lengthOfLongestSubstring(String s) {

HashMap<Character,Integer> map=new HashMap<Character,Integer>();

int maxLength=0;
int left=0;
int right=0;

    for(char c:s.toCharArray()){
        if(map.containsKey(c)&&left<=map.get(c)){
        left=map.get(c)+1;
        }else{

        }
    }


        }
}
