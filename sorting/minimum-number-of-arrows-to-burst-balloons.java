class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[0], b[0]));
        List<int[]>res=new ArrayList<>();
        int n=points.length;
        for(int i=0;i<n;i++){
            if(res.isEmpty()){
                res.add(points[i]);
            }else{
                int[]pre=res.get(res.size()-1);
                int[]cur=points[i];
                if(pre[1]>=cur[0]){
                    pre[1] = Math.min(pre[1], cur[1]);
                }else{
                    res.add(cur);
                }
            }
        }
        int size=res.size();
        return size;        
    }
}