class Trie {

    /** Initialize your data structure here. */
    class TrieNode{
        Map<Character,TrieNode> children = new HashMap();
        boolean isWord;
    }
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            Character c = word.charAt(i);
            if(!curr.children.containsKey(c))
                curr.children.put(c,new TrieNode()); //add new node and put its reference in the value of children map
            curr = curr.children.get(c); //move pointer to next node
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            Character c = word.charAt(i);
            if(curr.children.get(c)==null)
                return false;
            curr = curr.children.get(c);
        }
        return curr.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++){
            Character c = prefix.charAt(i);
            if(curr.children.get(c)==null)
                return false;
            curr = curr.children.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
