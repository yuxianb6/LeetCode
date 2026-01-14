class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int ans=0;
        int n=citations.length;
        for(int i=citations.length-1;i>=0;i--){
            if (citations[i]<=n-i) {
                ans=citations[i];
                break;
            }
        }
        if(ans==0){
            return 1;
        }
        return ans;
        
    }
}