class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[]ans=new int[nums.length];
        ans[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            ans[i]=ans[i-1]*nums[i];
        }

        int end=1;
        for(int i=nums.length-1;i>=0;i--){
            if(i==0){
                ans[i]=end;
            }else{
                ans[i]=ans[i-1]*end;
                end=end*nums[i];
            }
            
        }
        return ans;
    }
}