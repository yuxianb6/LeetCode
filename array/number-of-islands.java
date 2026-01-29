class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;
        boolean[][]visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]&&grid[i][j]=='1'){
                    dfs(i,j,grid,visited);
                    ans++;
                }
            }
        }
        return ans;

    }
    public void dfs(int row,int col,char[][]grid,boolean[][]visited){
        int m=grid.length;
        int n=grid[0].length;
        if(row<0||col<0||col>=n||row>=m){
            return;
        }
        if(grid[row][col]=='0'){
            return;
        }
        if(visited[row][col]){
            return;
        }
        visited[row][col]=true;
        dfs(row+1,col,grid,visited);
        dfs(row-1,col,grid,visited);
        dfs(row,col+1,grid,visited);
        dfs(row,col-1,grid,visited);
        return;




    }



}
