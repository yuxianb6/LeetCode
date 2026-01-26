class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer>ans=new ArrayList<>();
        int lc=0;
        int rc=matrix[0].length-1;
        int ur=0;
        int dr=matrix.length-1;
        while(lc<=rc&&ur<=dr){
            // if(lc==rc&&ur==dr){
            //     ans.add(matrix[ur][lc]);
            // }
            for(int i=lc;i<=rc;i++){
                ans.add(matrix[ur][i]);
            }

            for(int j=ur+1;j<=dr;j++){
                ans.add(matrix[j][rc]);
            }

            if(ur < dr) {
                for(int i = rc - 1; i >= lc; i--) ans.add(matrix[dr][i]);
            }
            if(lc < rc) {
                for(int i = dr - 1; i > ur; i--) ans.add(matrix[i][lc]);
            }
              
            

            rc--;
            lc++;
            ur++;
            dr--;
        }
        return ans;
        
    }
}