import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        // 슬라이딩 윈도우 구현
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // 현재 문자가 해시맵에 존재하고, 윈도우의 시작 인덱스보다 크거나 같다면
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= left) {
                // 시작 인덱스 갱신
                left = charIndexMap.get(currentChar) + 1;
            }

            // 해시맵에 현재 문자 인덱스를 저장
            charIndexMap.put(currentChar, right);

            // 최대 길이 업뎃
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
