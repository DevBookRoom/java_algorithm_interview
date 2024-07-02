
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public String[] reorderLogFiles(String[] logs) {
        //문자로그를 저장할 문자리스트
        List<String> strList = new ArrayList<>();
        //숫자로그를 저장할 숫자리스트
        List<String> numList = new ArrayList<>();

        for (String log : logs) {
            //가장앞은 식별자이므로,순서에 영향 안끼치므로 그다음번째를 확인한다.
            //숫자로그라면 숫자리스트에 삽입
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                numList.add(log);
                //문자로그라면 문자리스트에 삽입
            } else {
                strList.add(log);
            }
        }
        //문자리스트 정렬진행
        Collections.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] s1x=s1.split(" ",2);
                String[] s2x=s2.split(" ",2);

                int compared=s1x[1].compareTo(s2x[1]);
                if(compared==0){
                    return s1x[0].compareTo(s2x[0]);
                }else{
                    return compared;
                }
            }
        });


        //문자리스트뒤에 숫자리스트릴 이어붙인다.
        //숫자리로그는 '입력순서대로' 라는 제약조건이 있으므로 따로 정렬하지 않는다.
        strList.addAll(numList);

        //리스트를 String배열로 변환해 리턴한다.
        return strList.toArray(new String[0]);

    }

}