class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int window=words.length*words[0].length();
        int wordLen=words[0].length();
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<s.length()-window;i++){
            if(isConcatenation(s.substring(i, i+window+1),words)){
                ans.add(i);
            }
        }
        return ans;  
    }
    public boolean isConcatenation(String word,String[]words){
        HashMap<String,Integer>counts=new HashMap<>();
        int check=0;
        for(String w:words){
            if(counts.containsKey(w)){
                counts.put(w,counts.get(w)+1);
            }else{
                counts.put(w,1);
                check++;

            }
        }
        int valid=0;
        for(int i=0;i<word.length()-words[0].length();i+=words[0].length()){
            String piece=word.substring(i,i+words[0].length());
            
            if(!counts.containsKey(piece)){
                return false;
            }else{
                counts.put(piece,counts.get(piece)-1);
            }
            if(counts.get(piece)==0){
                valid++;
            }
        }
        if (valid==check) {return true;}
        return false;
    }
}