class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int n=nums.length;
        int cur=0;
        int ans=Integer.MAX_VALUE;
        for(int right=left;right<n;right++){
            cur+=nums[right];
            while(cur>=target){
                ans=Math.min(ans,right-left+1);
                cur-=nums[left];
                left++;
            }

        }
        if(ans==Integer.MAX_VALUE){
            return 0;
        }
        return ans;
        

        
    }
}