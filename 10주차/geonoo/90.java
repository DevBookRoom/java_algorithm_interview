import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> results = new ArrayList<>();

        // 주어진 expression을 순회하면서 연산자를 찾음
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // 현재 문자가 연산자라면, 좌우로 문자열을 분할
            if (c == '+' || c == '-' || c == '*') {
                String leftPart = expression.substring(0, i);
                String rightPart = expression.substring(i + 1);

                // 분할된 좌측, 우측 부분에 대해 재귀적으로 호출하여 결과를 가져옴
                List<Integer> leftResults = diffWaysToCompute(leftPart);
                List<Integer> rightResults = diffWaysToCompute(rightPart);

                // 좌측 결과와 우측 결과를 현재 연산자를 기준으로 조합
                for (int left : leftResults) {
                    for (int right : rightResults) {
                        int currentResult = 0;
                        if (c == '+') {
                            currentResult = left + right;
                        } else if (c == '-') {
                            currentResult = left - right;
                        } else if (c == '*') {
                            currentResult = left * right;
                        }
                        results.add(currentResult);
                    }
                }
            }
        }

        // 만약 연산자가 없고 숫자만 있는 경우, 직접 결과에 추가
        if (results.isEmpty()) {
            results.add(Integer.parseInt(expression));
        }

        return results;
    }
}
