class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bs = new HashSet<String>();
        Map<String, Integer> wordCount = new HashMap<>();
        
        String[] paraToWord = paragraph.split("\\W+");
        
        for(String b:banned)
            bs.add(b);
        
        for(String pw:paraToWord){
            pw = pw.toLowerCase();
            if(!bs.contains(pw)){
                wordCount.put(pw,wordCount.getOrDefault(pw,0)+1);
            }
        }
        
        int maxCount = 0;
        String result="";
        for(String key:wordCount.keySet()){
            if(wordCount.get(key)>maxCount){
                maxCount = wordCount.get(key);
                result = key;
            }
        }
        /*Map.Entry<String,Integer> maxEntry = null;
        for(Map.Entry<String,Integer> entry:wordCount.entrySet()){
            if(maxEntry==null || entry.getValue().compareTo(maxEntry.getValue())>0)
                maxEntry = entry;
        }*/
        
        return result;
    }
}
