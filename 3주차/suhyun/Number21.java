class Solution {
    public String removeDuplicateLetters(String s) {

        Map<Character, Integer> counter = new HashMap<>();

        Map<Character, Boolean> seen = new HashMap<>();

        // 스택
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            counter.put(c, counter.get(c) == null ? 1 : counter.get(c) + 1);
        }

        for (char c : s.toCharArray()) {
            // 처리하는 문자의 경우 카운터 -1 처리해둠 중복 확인을 위해서 중복 아니면 이 처리에서 0으로 됨
            counter.put(c, counter.get(c) - 1);

            // 처리한 문자는 건너뛰기
            if (seen.get(c) != null && seen.get(c) == true) {
                continue;
            }
            // 스택 문자 뒤에 붙어야 하는 경우 스택 제거
            while (!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0) {
                // 현재 문자 처리하지 못한 거로 표시
                seen.put(stack.pop(), false);
            }

            stack.push(c);

            seen.put(c, true);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();

    }
}