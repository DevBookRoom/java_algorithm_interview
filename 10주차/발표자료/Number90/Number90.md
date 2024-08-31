# 241 Different Ways to Add Parentheses

사이트: LeetCode
URL: https://leetcode.com/problems/different-ways-to-add-parentheses/description/
유형: DFS
푼 날: 2024/08/30

- Contents
    
    

# Problem 💻

## 문제

Given a string `expression` of numbers and operators, return *all possible results from computing all the different possible ways to group numbers and operators*. You may return the answer in **any order**.

The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed `104`.

## 예제 입출력

![image.png](241%20Different%20Ways%20to%20Add%20Parentheses%20134dd68409c5470983644ae7cead0b68/image.png)

---

# Approach 1 ⭕

## DFS

- **깊이 우선 탐색**은 그래프나 트리에서 한 노드에서 시작하여 가능한 깊이까지 탐색한 후, 더 이상 진행할 수 없게 되면 백트래킹하여 다른 경로를 탐색하는 방법입니다.
- DFS는 주로 스택(재귀 호출)을 사용하여 탐색을 진행하며, 각 노드를 방문한 후 그 노드에서 갈 수 있는 다음 노드를 깊이 탐색합니다.

- 어짜피 연산기호로 나눈 다음 또 나누고 나누니까 나눌 수 있을 때 까지 싹 처리하도록 탐색

![image.png](241%20Different%20Ways%20to%20Add%20Parentheses%20134dd68409c5470983644ae7cead0b68/image%201.png)

![image.png](241%20Different%20Ways%20to%20Add%20Parentheses%20134dd68409c5470983644ae7cead0b68/image%202.png)

# Solution 💡

```java
import java.util.*;

public class Num90 {

    private char[] expressionArr;
    private String expression;
    private Set<Character> operatorSet = new HashSet();

    public static void main(String[] args) {
        Num90 num90 = new Num90();
        num90.diffWaysToCompute("4*2+1");
    }

    public List<Integer> diffWaysToCompute(String expression){
        operatorSet.add('*');
        operatorSet.add('-');
        operatorSet.add('+');
        this.expression = expression;
        expressionArr = expression.toCharArray();

        return dfs(0,expressionArr.length-1);
    }

    private List<Integer> dfs(int start , int end){
        List<Integer> res = new LinkedList<>();
        for(int i = start ; i < end ; i++){
            if(operatorSet.contains(expressionArr[i])){
                List<Integer> leftList = dfs(start, i -1);
                List<Integer> rightList = dfs(i+1, end);
                for(Integer left : leftList){
                    for(Integer right : rightList){
                        Integer totalVal = calculate(left , right , expressionArr[i]);
                        res.add(totalVal);
                    }
                }
            }
        }
        if(res.isEmpty()){
            res.add(Integer.parseInt(expression.substring(start,end+1)));
        }
        return res;
    }

    private Integer calculate(Integer num1 , Integer num2 , char operator){
        switch (operator){
            case '*':
                return num1 * num2;
            case '+':
                return num1+num2;
            case '-':
                return num1- num2;
            default:
                return -1;
        }
    }
}

```

### 결론

- 연산 기호 기준으로 크게 구분 한 번 만들고 그 나눈 것 중에서도 연산기호가 포함 된 경우가 있으니까 없을 때 까지 나눠서 처리하자

---

# Reference 📄

[https://www.youtube.com/watch?v=ZNkquA2htPM](https://www.youtube.com/watch?v=ZNkquA2htPM)

- 구글링