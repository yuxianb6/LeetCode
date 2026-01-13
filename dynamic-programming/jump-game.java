class Solution {
    public boolean canJump(int[] nums) {
        int pos=0;
        int max=nums[0];
        while(pos<nums.length&&pos<=max){
            max=Math.max(pos+nums[pos],max);
            pos++;
        }
        if(max>=nums.length-1){
            return true;
        }else{
            return false;
        }


        
    }
}