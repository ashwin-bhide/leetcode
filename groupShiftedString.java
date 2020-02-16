class Solution {
    public String getStringDifferenceAsKey(String s){
        String key = "";
        char[] schar = s.toCharArray();
        for(int i=1;i<s.length();++i){
            // find difference between ascii value of consecutive chars
            int diff = schar[i]-schar[i-1];
            // if diff < 0; for eg 'ba' (97-98 = -1); add offset to make it consistent
            if(diff<0)
                diff += 26;
            // store difference as chars; so 9898 is stored as bb
            key += (char)(diff + 'a');
        }
        return key;
    }
    public List<List<String>> groupStrings(String[] strings) {
        Map<String,ArrayList<String>> myMap = new HashMap<String,ArrayList<String>>();
        for(String s:strings){
            String key = getStringDifferenceAsKey(s);
            // if map does not contain key; add key and initialize corresponding ArrayList
            if(!myMap.containsKey(key))
                myMap.put(key,new ArrayList<String>());
            myMap.get(key).add(s);
        }
        return new ArrayList(myMap.values());
    }
}
