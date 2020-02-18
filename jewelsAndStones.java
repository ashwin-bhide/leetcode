class Solution {
    public int numJewelsInStones(String J, String S) {
        char[] jarray = J.toCharArray();
        char[] sarray = S.toCharArray();
        Set<Character> mySet = new HashSet<Character>();
        for(int i=0;i<jarray.length;++i)
            if(!mySet.contains(jarray[i]))
                mySet.add(jarray[i]);
        int count = 0;
        for(int i=0;i<sarray.length;++i)
            if(mySet.contains(sarray[i]))
                count++;
        
        return count;
        
    }
}
