class Solution {
    public int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int pos=0;
        int curMax=nums[pos];
        int max=curMax;
        int ans=0;
        while(pos<nums.length){
            if(pos==curMax){
                ans++;
                curMax=max;
            }
            max=Math.max(pos+nums[pos],max);
            pos++;
        }
        return ans;
        
    }
}