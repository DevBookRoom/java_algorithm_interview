import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static String removeDuplicateLetters(String s) {
        // 각 문자의 빈도수 계산
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // 스택과 문자 방문 여부 추적을 위한 집합
        Deque<Character> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[26];

        for (char c : s.toCharArray()) {
            // 현재 문자의 빈도수 감소
            count[c - 'a']--;

            // 이미 스택에 있는 문자는 건너뜀
            if (visited[c - 'a']) continue;

            // 스택의 마지막 문자와 현재 문자를 비교하여 조건에 맞으면 스택에서 제거
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }

            // 현재 문자를 스택에 추가하고 방문 기록
            stack.push(c);
            visited[c - 'a'] = true;
        }

        // 스택의 문자를 모아 결과 문자열 생성
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }

        return sb.toString();
    }
}
