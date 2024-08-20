import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        // int 배열 -> String 배열
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Comparator 선언
        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 문자 단위로 합쳤을 때 더 큰거 구하기.
                // '30'과 '9'가 있으면 '309'가 큰지 '930'이 큰지 비교한다.
                String order1 = o1 + o2;
                String order2 = o2 + o1;
                return order2.compareTo(order1);
            }
        });

        // 엣지케이스. 정렬 기준 제일 큰 값이 0이면 그냥 0리턴
        if (strNums[0].equals("0")) {
            return "0";
        }

        // 하나의 문자열로 결과 리턴
        StringBuilder sb = new StringBuilder();
        for (String num : strNums) {
            sb.append(num);
        }

        return sb.toString();
    }
}
