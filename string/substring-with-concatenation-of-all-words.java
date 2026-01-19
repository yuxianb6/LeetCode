class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int window = words.length * words[0].length();
        int wordLen = words[0].length();
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i <= s.length() - window; i++) {  // 修正1
            if(isConcatenation(s.substring(i, i + window), words)) {  // 修正2
                ans.add(i);
            }
        }
        return ans;  
    }
    
    public boolean isConcatenation(String word, String[] words) {
        HashMap<String, Integer> counts = new HashMap<>();
        
        for(String w : words) {
            counts.put(w, counts.getOrDefault(w, 0) + 1);
        }
        
        for(int i = 0; i <= word.length() - words[0].length(); i += words[0].length()) {  
            String piece = word.substring(i, i + words[0].length());
            
            if(!counts.containsKey(piece)) {
                return false;
            }
            
            counts.put(piece, counts.get(piece) - 1);
            if(counts.get(piece) < 0) { 
                return false;
            }
        }
        
        for(int count : counts.values()) {
            if(count != 0) {
                return false;
            }
        }
        
        return true;
    }
}