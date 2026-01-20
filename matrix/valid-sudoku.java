class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][]row=new boolean[9][9];
        boolean[][]col=new boolean[9][9];
        boolean[][]grid=new boolean[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char c = board[i][j];
                if(c == '.') continue;
                int num = c - '1'; 
                int gridIndex=(i / 3) * 3 + (j / 3);
                if(row[i][num]||col[j][num]||grid[gridIndex][num]){
                    return false;
                }
                row[i][num]=true;
                col[j][num]=true;
                grid[gridIndex][num]=true;

            }
        }
        return true;

        
    }
}