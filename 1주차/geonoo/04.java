import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // ban값 비교를 위해 HashSet으로 변환
        Set<String> bans = new HashSet<>(Arrays.asList(banned));

        // replaceAll() -> 특수문자 변환
        // 소문자 변환, 공백 기준 분리
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

        // 단어 개수 저장
        Map<String, Integer> counts = new HashMap<>();

        // 단어 빈도수 계산
        for (String word : words) {
            if (!bans.contains(word)) {
                counts.put(word, counts.getOrDefault(word, 0) +1);
            }
        }

        // 가장 많이 나온 단어 찾기
        // counts 엔트리셋으로 가져와서 비교 후 key값 리턴
        String mostCommon = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommon = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostCommon;
    }
}
