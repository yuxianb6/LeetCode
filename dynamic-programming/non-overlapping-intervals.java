class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });
        int ans=0;
        for(int i=0;i<intervals.length-1;i++){
            if(intervals[i][1]>intervals[i+1][0]){
                ans++;
                if(intervals[i][1]<intervals[i+1][1]){
                    intervals[i+1][0]=intervals[i][0];
                    intervals[i+1][1]=intervals[i][1];
                }
            }
        }
        return ans;
    }
}