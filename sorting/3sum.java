class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i!=0&&nums[i]==nums[i-1]){
                continue;
            }else{
                int left=i+1;
                int right=nums.length-1;
                while(left<right){
                    if(nums[left]+nums[right]==-nums[i]){
                        ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                        right--;
                    }else if(nums[left]+nums[right]>-nums[i]){
                        right--;
                    }else{
                        left++;
                    }
                }
            }

        }
        return ans;
    }
}
