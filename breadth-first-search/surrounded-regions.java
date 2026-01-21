class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                dfs(i,0,board);

            }
            if(board[i][n-1]=='O'){
                dfs(i,n-1,board);

            }

        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O'){
                dfs(0,j,board);

            }
            if(board[m-1][j]=='O'){
                dfs(m-1,j,board);
            }
                
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='S'){
                    board[i][j]='O';
                }else
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        return;
        
    }
    public void dfs(int row,int col,char[][]board){
        int m=board.length;
        int n=board[0].length;
        if(row<0||row>=m||col<0||col>=n){
            return;
        }
        if(board[row][col]=='X'){
            return;
        }
        if(board[row][col]=='O'){
            board[row][col]='S';
            dfs(row+1,col,board);
            dfs(row-1,col,board);
            dfs(row,col+1,board);
            dfs(row,col-1,board);
        }


    }
}
