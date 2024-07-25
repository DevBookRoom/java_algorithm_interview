import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String,Ineger> m=new HashMap<>();
        for(String p:participant){
            m.put(p,m.getOrDefault(p,0)+1);//참가자를 다넣음
        }

        for(String c:completion){
            int left=m.put(c);//완주한사람
            if(left==1){//완주한 사람인 경우 1이 반환됨
                m.remove(c);
            }else{ //동명이인인 경우 2명임/갯수 하나 뺴기
                m.put(c,left-1);
            }
        }
        //남아있는 유일한 키 리턴
        return m.entrySet().iterator().next().getKey();

        /*
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;
        for(i=0;i<completion.length;i++) {
            if(!participant[i].equals(completion[i])) {
                break;

            }

        }
        return   participant[i];

        */
    }
}