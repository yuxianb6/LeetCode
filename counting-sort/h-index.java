class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int n=citations.length;
        for(int i=citations.length;i>0;i--){
            if (citations[n-i]>=i) {
                return i;

            }
        }
        return 0;
        
    }
}