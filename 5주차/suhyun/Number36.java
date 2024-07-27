import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        // 빈값이면 빈값 그대로 반환
        if (digits.length() == 0) {
            return result;
        }

        Map<Character, List<Character>> dic = new HashMap<>();
        dic.put('0', List.of());
        dic.put('1', List.of());
        dic.put('2', List.of('a', 'b', 'c'));
        dic.put('3', List.of('d', 'e', 'f'));
        dic.put('4', List.of('g', 'h', 'i'));
        dic.put('5', List.of('j', 'k', 'l'));
        dic.put('6', List.of('m', 'n', 'o'));
        dic.put('7', List.of('p', 'q', 'r', 's'));
        dic.put('8', List.of('t', 'u', 'v'));
        dic.put('9', List.of('w', 'x', 'y', 'z'));

        dfs(result, dic, digits, 0, new StringBuilder());
        return result;

    };

    void dfs(List<String> result, Map<Character, List<Character>> dic, String digits, int index, StringBuilder path) {

        // 전부 다 탐색한 경우 . dfs니까 깊이가 끝인 경우
        if (path.length() == digits.length()) {
            result.add(String.valueOf(path));
            return;
        }

        // 탐색을 하는데 재귀로 탐색 dfs
        for (Character c : dic.get(digits.charAt(index))) {
            dfs(result, dic, digits, index + 1, new StringBuilder(path).append(c));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.letterCombinations("23");
    }
}