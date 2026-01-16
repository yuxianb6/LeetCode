class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n=words.length;
        int curRow=0;

        List<List<String>>rows=new ArrayList<>();
        List<String> row=new ArrayList<>();
        List<Integer>wordLen=new ArrayList<>();
        List<String> ans=new ArrayList<>();

        for(int index=0;index<n;index++){
            int toAdd=words[index].length();
            if(row.isEmpty()){
                row.add(words[index]);
                curRow+=toAdd;

                
            }else{
                if(curRow+toAdd+row.size()>maxWidth){
                    rows.add(new ArrayList<>(row)); 
                    row.clear();
                    wordLen.add(curRow);
                    curRow=0;
                    
                    row.add(words[index]);
                    curRow += toAdd;
                }else{
                    row.add(words[index]);
                    curRow+=toAdd;
                }
            }
        }
        rows.add(new ArrayList<>(row));
        wordLen.add(curRow);

        for(int i=0;i<rows.size()-1;i++){
            StringBuilder sb=new StringBuilder();
            int gaps = rows.get(i).size() - 1;
            int spaces = maxWidth - wordLen.get(i);
            if (gaps == 0) {
                sb.append(rows.get(i).get(0));
                sb.append(" ".repeat(spaces));
                ans.add(sb.toString());
                continue;
            }
            int avg = spaces / gaps;
            int extra = spaces % gaps;

            for(int j=0;j<rows.get(i).size();j++){
                sb.append(rows.get(i).get(j));
                if (j < gaps) {
                    sb.append(" ".repeat(avg + (j < extra ? 1 : 0)));
                }

            }
            ans.add(sb.toString());
        }
        List<String> last = rows.get(rows.size() - 1);
        StringBuilder lastRow=new StringBuilder();
        for (int i = 0; i < last.size(); i++) {
            lastRow.append(last.get(i));
            if (i < last.size() - 1) lastRow.append(" ");
        }
        lastRow.append(" ".repeat(maxWidth - lastRow.length()));
        ans.add(lastRow.toString());
        return ans;
        
    }
}