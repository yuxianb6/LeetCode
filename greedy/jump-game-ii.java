class Solution {
    public int jump(int[] nums) {
        int pos=0;
        int curMax=nums[pos];
        int ans=1;
        while(pos<nums.length){
            if(pos==curMax){
                ans++;
            }
            curMax=Math.max(pos+nums[pos],curMax);
            pos++;
        }
        return ans;
        
    }
}