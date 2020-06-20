class Solution {
    public class TrieNode{
        Map<Character,TrieNode> children;
        TrieNode(){
            this.children = new HashMap();
        }
    }
    public boolean searchAndInsert(TrieNode root,String word){
        boolean isFound = true;
        for(char c:word.toCharArray()){
            if(root.children.get(c)==null){
                root.children.put(c,new TrieNode());
                isFound = false;         //char not found in existing trie
            }
            root = root.children.get(c); 
        }
        return isFound;
    }
    public String longestDupSubstring(String S) {
        //binary search(for max Length of substring) and Trie approach
        if(S.length()==0)
            return "";
        
        int minLen = 1, maxLen = S.length();
        String result = "";
        //TrieNode root = new TrieNode();
        
        while(minLen<=maxLen){
            int mid = minLen + (maxLen-minLen)/2;
            //check for substring of size = m in given S
            String curr = findDuplicate(mid,S);
            if(curr != ""){
                minLen = mid+1;
                result = curr; //assign to final result and try finding longer length substring
            }
            else
                maxLen = mid-1;
        }
        
        return result;
    }
    private String findDuplicate(int len,String S){
        TrieNode root = new TrieNode(); //create ONE trie for given "len" of substring
        int SLen = S.length();
        StringBuilder subS;
        for(int i=0;i<=SLen-len;i++){
            subS = new StringBuilder(S.substring(i,i+len));
            if(searchAndInsert(root,subS.toString()))
                return subS.toString();
        }
        return "";
    }
}
