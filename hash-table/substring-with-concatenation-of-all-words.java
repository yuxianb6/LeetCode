class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLen=words[0].length();
        List<Integer> ans = new ArrayList<>();
        int wordCount = words.length;
        HashMap<String,Integer>targetCount=new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(targetCount.containsKey(words[i])){
                targetCount.put(words[i], targetCount.get(words[i])+1);
            }else{
                targetCount.put(words[i], 1);
            }
        }

        for(int offset=0;offset<words[0].length();offset++){
            HashMap<String, Integer> windowCount = new HashMap<>();
            int left = offset;
            int count = 0;
            for (int right = offset; right + wordLen <= s.length(); right += wordLen) {

                String word = s.substring(right, right + wordLen);
                if (!targetCount.containsKey(word)) {
                    windowCount.clear();
                    count = 0;
                    left = right + wordLen;
                    continue;
                }
                windowCount.put(word, windowCount.getOrDefault(word, 0) + 1);
                count++;
                while (windowCount.get(word) > targetCount.get(word)) {
                    String leftWord = s.substring(left, left + wordLen);
                    windowCount.put(leftWord, windowCount.get(leftWord) - 1);
                    left += wordLen;
                    count--;
                }
                if (count == wordCount) {
                    ans.add(left);
                }
            }
        }
        return ans;
    }
}