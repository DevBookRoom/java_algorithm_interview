import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();

        // toCharArray() -> 문자열 문자 배열로 변환
        // ['ABC'] -> ['A', 'B', 'C']
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            // 문자열로 재변환하여 key로 활용
            String sorted = new String(chars);

            // ans에 없으면 key값과 함께 빈 리스트 삽입
            if (!ans.containsKey(sorted)) {
                ans.put(sorted, new ArrayList<>());
            }
            // key값 가져와서 문자열에 추가
            ans.get(sorted).add(str);
        }

        return new ArrayList<>(ans.values());
    }
}
