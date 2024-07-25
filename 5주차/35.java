class Solution {

    public void dfs(int i,int j, char[][]grid){
        //현재 그리드 밖이거나 0인 경우 종료
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]=='0')
            return;
        //한번만 탐색하기 위해 0으로 변경
        grid[i][j]='0';
        dfs(i,j+1,grid);//동
        dfs(i,j-1,grid);//서
        dfs(i+1,j,grid);//남
        dfs(i-1,j,grid);//북

    }

    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                //1이면 탐색시작
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    //재귀dfs가 모두끝나면 섬하나가 완성(탐색한곳은 grid에서 0으로 초기화됨)
                    count++;
                }
            }
        }
        return count;
    }
}