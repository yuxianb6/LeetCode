class Solution {
    public void setZeroes(int[][] matrix) {
        int rowNum=matrix.length;
        int colNum=matrix[0].length;
        boolean firstRow=false;
        boolean firstCol=false;
        for(int i=0;i<colNum;i++){
            if(matrix[0][i]==0){
                firstRow=true;
            }
        }
        for (int i = 0; i < rowNum; i++) {
            if (matrix[i][0] == 0) firstCol = true;
        }

        for(int i=1;i<rowNum;i++){
            for(int j=1;j<colNum;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<colNum;i++){
            if(matrix[0][i]==0){
                for(int j=1;j<rowNum;j++){
                    matrix[j][i]=0;
                }
            }
        }
        for(int i=1;i<rowNum;i++){
            if(matrix[i][0]==0){
                for(int j=1;j<colNum;j++){
                    matrix[i][j]=0;
                }
            }
        }

        if(firstCol){
            for(int i=0;i<rowNum;i++){
                matrix[i][0]=0;
            }

        }

        if(firstRow){
            for(int i=0;i<colNum;i++){
                matrix[0][i]=0;
            }

        }
    
    }
}