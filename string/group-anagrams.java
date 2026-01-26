class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>group=new HashMap<>();
        List<List<String>>ans=new ArrayList<>();
        for(String str:strs){
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String orderedS=new String(chars);
            if(group.containsKey(orderedS)){
                group.get(orderedS).add(str);
            }else{
                List<String>list=new ArrayList<>();
                list.add(str);
                group.put(orderedS, list);
            }

        }
        for(List<String> groupList:group.values()){
            ans.add(groupList);
        }
        return ans;
        
    }
}