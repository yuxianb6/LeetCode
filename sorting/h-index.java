class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int ans=0;
        int n=citations.length;
        for(int i=citations.length-1;i>0;i--){
            if (citations[i]<=n-i+1) {
                ans=citations[i];
                break;
            }
        }
        return ans;
        
    }
}