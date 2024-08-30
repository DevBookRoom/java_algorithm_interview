import java.util.*;

public class Number90 {

    private char[] expressionArr;
    private String expression;
    private Set<Character> operatorSet = new HashSet();

    public static void main(String[] args) {
        Number90 num90 = new Number90();
        num90.diffWaysToCompute("4*2+1");
    }

    public List<Integer> diffWaysToCompute(String expression) {
        operatorSet.add('*');
        operatorSet.add('-');
        operatorSet.add('+');
        this.expression = expression;
        expressionArr = expression.toCharArray();

        return dfs(0, expressionArr.length - 1);
    }

    private List<Integer> dfs(int start, int end) {
        List<Integer> res = new LinkedList<>();
        for (int i = start; i < end; i++) {
            if (operatorSet.contains(expressionArr[i])) {
                List<Integer> leftList = dfs(start, i - 1);
                List<Integer> rightList = dfs(i + 1, end);
                for (Integer left : leftList) {
                    for (Integer right : rightList) {
                        Integer totalVal = calculate(left, right, expressionArr[i]);
                        res.add(totalVal);
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression.substring(start, end + 1)));
        }
        return res;
    }

    private Integer calculate(Integer num1, Integer num2, char operator) {
        switch (operator) {
            case '*':
                return num1 * num2;
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            default:
                return -1;
        }
    }
}
