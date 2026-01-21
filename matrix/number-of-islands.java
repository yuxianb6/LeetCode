class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;
        boolean[][]visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((!visited[i][j])&&grid[i][j]=='1'){
                    dfs(i,j,visited,grid);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(int row,int col,boolean[][]visited,char[][]grid){
        int m=grid.length;
        int n=grid[0].length;
        

       
        if(row<0||col<0||row>=m||col>=n||grid[row][col]=='0'){
            return;
        }else if(visited[row][col]){
            return;

            

        }else{
            visited[row][col]=true;
            dfs(row+1,col,visited,grid);
            dfs(row-1,col,visited,grid);
            dfs(row,col+1,visited,grid);
            dfs(row,col-1,visited,grid);
            
        }
    }

}
