class Solution {
    public int candy(int[] ratings) {
        int ans=ratings.length;
        int n=ans;
        for(int i=1;i<n;i++){
            if(ratings[i]!=ratings[i-1]){
                ans++;
            }
        }
        return ans;
        
    }
}