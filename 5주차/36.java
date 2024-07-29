class Solution {
    public List<String> letterCombinations(String digits) {
        List<String>result=new ArrayList<>();

        if(digits.length()==0)return result;

        Map<Character,List<Character>>dic=new HashMap<>();
        dic.put('0',List.of());
        dic.put('1',List.of());
        dic.put('2',List.of('a','b','c'));
        dic.put('3',List.of('d','e','f'));
        dic.put('5', List.of'j', 'k', 'l'));
        dic.put('6', List.of('m', 'n', 'o');
        dic.put('7', List.of('p', 'q', 'r', 's'));
        dic.put('8', List.of('t', 'u', 'v'));
        dic.put('9', List.of('w', 'X' , 'y', 'z' ));
        // 현재자리0, 빈문자열이용DFS 시작
        dfs(result, dic, digits, 0, new StringBuilder());
        return result;
    }
}