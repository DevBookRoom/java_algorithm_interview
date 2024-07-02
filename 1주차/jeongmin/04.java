package 문자열;

import java.util.*;
public class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String,Integer>map=new HashMap<>();
        //소문자로 변경
        String words=paragraph.toLowerCase();
        //금지된 언어룰 ""로 replace
        for(int i=0;i<banned.length;i++){
            words= words.replaceAll(banned[i],"");
        }
        //연속적으로 단어문자가 아닌것들은 " "로 replace후 공백기준 split
        String []str=words.replaceAll("\\W+"," ").split(" ");

        for(String key:str){
            //존재하지않는 단어라면 기본값 0,있으면 추출한 값에 +1을 한다.
            map.put(key,map.getOrDefault(key,0)+1);
        }

        int maxValue=0;
        String maxkey = null;
        Iterator it=map.entrySet().iterator();
        while(it.hasNext()){
            //가장흔하게 등장하는 단어 추출
            Map.Entry entry=(Map.Entry)it.next();
            if(entry.getKey()!="") {
                int tmp = (int) entry.getValue();
                if (tmp > maxValue) {
                    maxValue = tmp;
                    maxkey = (String) entry.getKey();
                }
            }
        }
        return maxkey;
    }
}