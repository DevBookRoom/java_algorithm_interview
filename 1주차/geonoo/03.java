import java.util.*;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        // 문자 숫자 로그 리스트
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            // 식별자 분리 로직
            int space = log.indexOf(" ");
            String id = log.substring(0, space);
            String content = log.substring(space +1);

            // 문자 숫자 로그 분리 로직
            if (Character.isDigit(content.charAt(0))) {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }

        // 문자 로그 정렬
        Collections.sort(letterLogs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int space1 = o1.indexOf(" ");
                int space2 = o2.indexOf(" ");
                String id1 = o1.substring(0, space1);
                String content1 = o1.substring(space1 +1);
                String id2 = o2.substring(0, space2);
                String content2 = o2.substring(space2 +1);

                // compareTo로 비교.
                // -> int의 경우 크다(1), 같다(0), 작다(-1)
                // -> 문자열의 경우 아스키값 기준으로 계산.
                int comp = content1.compareTo(content2);
                if (comp == 0) {
                    return id1.compareTo(id2);
                }
                return comp;
            }
        });

        // 배열에 저장
        String[] ans = new String[logs.length];
        int i = 0;

        for (String log : letterLogs) {
            ans[i++] = log;
        }
        for (String log : digitLogs) {
            ans[i++] = log;
        }

        return ans;

    }
}
