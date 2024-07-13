//queue는 선입선출//12345
//stack은 선입후출//54321

//add는 큐 맨뒤에 값 삽입
//remove 큐 맨앞에 값 제거
package 문자열;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack=new ArrayDeque<>();
        int []result=new int[temperatures.length];

        for(int i=0;i<temperatures.length;i++){
            //현재온도가 스택에 마지막에 넣은 온도보다 높다면 꺼내서 결과 얻기
            //현재값이 최근에 들어온 값보다 크면 최근에 들어간 빼기! 그리고 나서 다시비교
            //현재 값보다 더큰지 비교
            while(!stack.isEmpty() &&temperatures[i]>temperatures[stack.peek()]){
                int last=stack.pop();
                result[last]=i-last;
            }
            stack.push(i);
        }

        return result;
    }
}
