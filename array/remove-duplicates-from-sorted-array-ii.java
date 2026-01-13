class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2){
            return nums.length;
        }
        int write=0;
        for(int num:nums){
            if(write>=2&&num==nums[write-2]){
            }else{
                nums[write] = num;
                write++;
            }
        }
        return write;


        
    }
}