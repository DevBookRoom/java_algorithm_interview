class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap <Character ,Integer> map=new HashMap<Character,Integer>();

        for(char s:stones.toCharArray()){
            if(map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }else{
                map.put(s,1);
            }
        }
        int cnt=0;
        for(char j:jewels.toCharArray()){
            if(map.containsKey(j)){
                cnt+=map.get(j);
            }
        }
return cnt;

        }
    }
