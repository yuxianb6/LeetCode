class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer>ans=new ArrayList<>();
        int lc=0;
        int rc=matrix[0].length-1;
        int ur=0;
        int dr=matrix.length-1;
        while(lc<=rc&&ur<=dr){
            if(lc==rc&&ur==dr){
                ans.add(matrix[ur][lc]);
            }
            for(int i=lc;i<rc;i++){
                ans.add(matrix[ur][i]);
            }
            for(int j=ur;j<dr;j++){
                ans.add(matrix[j][rc]);
            }
            for(int i=rc;i>lc;i--){
                ans.add(matrix[dr][i]);
            }
            for(int j=dr;j>ur;j--){
                ans.add(matrix[j][lc]);
            }
            rc--;
            lc++;
            ur++;
            dr--;
        }
        return ans;
        
    }
}