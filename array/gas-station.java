class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int[]get=new int[n];
        int can=0;
        for(int i=0;i<n;i++){
            get[i]=gas[i]-cost[i];
            can+=get[i];
        }
        if(can<0){
            return -1;
        }
        int ans=0;
        int cur=0;
        int point=ans;
        while(point<n){
            if(cur<0){
                ans=point;
                cur=get[point];
                point++;
            }else{
                cur+=get[point];
                point++;
            }
        }
        return ans;
    }
}