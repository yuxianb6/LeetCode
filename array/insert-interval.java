class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        List<int[]>res=new ArrayList<>();
        boolean insert=false;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][1]<newInterval[0]){
                res.add(intervals[i]);
            }else if(intervals[i][1] >= newInterval[0]
&& intervals[i][0] <= newInterval[1]){
                newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
                newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            }else if(intervals[i][0]>newInterval[1]){
                if(!insert){
                    insert=true;
                    res.add(newInterval);

                }
                res.add(intervals[i]);

            }

        }
        int size=res.size();
        int[][]ans=new int[size][2];
        for(int i=0;i<size;i++){
            ans[i]=res.get(i);

        }
        return ans;
    }
}