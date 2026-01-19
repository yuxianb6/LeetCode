class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer>index=new HashMap<>();
        int ans=0;
        int cur=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!index.containsKey(ch)){
                cur++;
                index.put(ch,i);
            }else{
                if(index.get(ch)>=i-cur){
                    cur=i-index.get(ch);
                    index.put(ch,i);
                }else{
                    index.put(ch,i);
                    cur++;
                }
            }
            ans=Math.max(ans,cur);

        }
        return ans;
    }
}