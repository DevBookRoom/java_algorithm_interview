class Solution {

    public void dfs(List<List<Integer>> results,int[]can,int target,int index,Deque<Integer>path){
        //0보다 작다면 목표값을 넘어섯으므로 리턴
        if(target<0)return ;
        //0이면 목표값에 도달햇으므로 결과에 추가하고 리턴
        if(target==0){
            results.add(new ArrayList<>(path));
            return ;
        }
        //자기자신보다 큰숫자를 dfs진행
        for(int i=index;i<can.length;i++){
            path.add(can[i]);//path에 현재 엘리먼트 추가
            dfs(results,can,target-can[i],i,path);//재귀dfs
            path.removeLast();//돌아온 이후로 현재 엘리먼트 삭제
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //결과 저장리스트
        List<List<Integer>> results=new ArrayList<>();
        //dfs시작 cand=[2,3,5,8] , target=8
        dfs(results,candidates,target,0,new ArrayDeque<>());
        return results;
    }
}