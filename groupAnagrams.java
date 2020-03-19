class Solution {
    public String sortString(String s){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            return new String(c);
        }
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null || strs.length==0)
            return null;
        
        HashMap<String,List> hm = new HashMap<String,List>();
        for(String s:strs){
            String sortedString = sortString(s);
            if(!hm.containsKey(sortedString))
                hm.put(sortedString,new ArrayList());
            hm.get(sortedString).add(s);
        }
        return new ArrayList(hm.values());
    }
}
