
class Solution {
    public void dfs(List<List<Integer>>results,LinkedList<Integer>elements,int n,int start,int k){
        if(k==0){
            // elements의 내용을 리스트형태로 결과에 삽입
            results.add(elements.stream().collect(Collectors.toList()));
            return ;
        }//n=5,k=3
        for(int i=start;i<=n;i++){
            //전달받은 엘리먼트에 더해 현재 엘리먼트 추가
            elements.add(i);
            //재귀 dfs
            dfs(results,elements,n,i+1,k-1);
            //재귀 돌아온 이후에는 마지막엘리먼트 삭제
            elements.removeLast();

        }
    }
    public List<List<Integer>> combine(int n, int k) {
        //결과 저장 리스트 선언
        List<List<Integer>>results=new ArrayList<>();
        //dfs시작
        dfs(results,new LinkedList<>(),n,1,k);

        return results;
    }
}