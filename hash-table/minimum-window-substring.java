class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer>need=new HashMap<>();
        HashMap<Character,Integer>count=new HashMap<>();
        int num=0;
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(!need.containsKey(ch)){
                need.put(ch,1);
                num++;
            }else{
                need.put(ch,need.get(ch)+1);
            }
        }
        int left=0;
        int valid=0;
        int min=Integer.MAX_VALUE;
        int start=0;
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            if(need.containsKey(c)){
                count.put(c,count.getOrDefault(c, 0)+1);
                if(count.get(c)==need.get(c)){
                    valid++;
                }
            }
            while(valid>=num){
                if(right-left+1<min){
                    min=right-left+1;
                    start=left;
                }
                char delete=s.charAt(left);
                if(need.containsKey(delete)){
                    count.put(delete,count.get(delete)-1);
                    if(count.get(delete)<need.get(delete)){
                        valid--;
                    }

                }
                left++;
            }
        }
        if(min==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start,start+min);
    }
}