class Solution {
    //create trie structure
    class TrieNode{
        Map<Character,TrieNode> children = new HashMap();
        String word = null;
    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        //populate trie
        for(String w:words){
            TrieNode curr = root;
            for(Character c:w.toCharArray()){
                if(curr.children.get(c)==null){//node not present
                    curr.children.put(c,new TrieNode());
                }
                curr = curr.children.get(c); //move pointer to next node
            }
            curr.word = w; //store word at leaf node
        }
        
        List<String> result = new ArrayList();
        //call backtracking
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                Character current = board[i][j];
                if(root.children.containsKey(current))
                    findWordsHelper(result,board,i,j,root);
            }
        }
        
        return result;
    }
    private void findWordsHelper(List<String> result,char[][] board,int r,int c,TrieNode node){
        //base condition
        if(node.word != null){
            result.add(node.word);
            node.word = null; //*** very important, helps in case of word like aaa(if not set to null after finding aaa) then it will not proceed to aaab; 
                                  //also prevents duplicate entries being added to result;
            return;
        }
        //constraint
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || !node.children.containsKey(board[r][c]))
            return;
        
        char temp = board[r][c];
        TrieNode next = node.children.get(board[r][c]);
        //choose
        board[r][c] = '#';
        //explore
        findWordsHelper(result,board,r+1,c,next);
        findWordsHelper(result,board,r-1,c,next);
        findWordsHelper(result,board,r,c+1,next);
        findWordsHelper(result,board,r,c-1,next);
        //unchoose
        board[r][c] = temp;
        
    }
}
