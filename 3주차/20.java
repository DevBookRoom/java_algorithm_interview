

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> table=new HashMap<>(){{
            put(')','(');
            put('}','{');
            put(']','[');
        }};
        Deque<Character> stack=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            //1. 닫는 괄호 아니면 스택에 넣어!
            if(!table.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
                //2. 닫는 괄호일때 스택에서 꺼낸 값이랑 map에서 나온 값이 다를때
            }else if(stack.isEmpty()||stack.pop()!=table.get(s.charAt(i))){
                return false;
            }
        }

        return stack.size()==0;
    }
}