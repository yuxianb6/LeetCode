class Solution {
    public int jump(int[] nums) {
        int curMax=0;
        int max=0;
        int ans=0;
        for(int pos=0;pos<nums.length-1;pos++){
            max=Math.max(max,pos+nums[pos]);
            if(pos==curMax){
                ans++;
                curMax=max;
            }
        }

        return ans;
        
    }
}