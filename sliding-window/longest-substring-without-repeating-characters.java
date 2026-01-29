public class Solution {

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character>has=new HashSet<>();
        int left=0;
        int ans=0;
        int cur=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            while(left<right&&has.contains(ch)){
                has.remove(s.charAt(left));
                left++;
            }
            has.add(ch);
            ans=Math.max(ans,right-left+1);
        }
        return ans;

    }
}