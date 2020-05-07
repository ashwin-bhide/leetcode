class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet(); //easy lookup
        for(String w:wordList)
            wordSet.add(w);
        if(!wordSet.contains(endWord))
            return 0;
        
        //we use BFS for shortest path, to reach from begin to end word
        Queue<String> q = new LinkedList();
        int level = 0;
        q.offer(beginWord);
        while(!q.isEmpty()){
            int qsize = q.size();
            level++;
            for(int k=0;k<qsize;k++){
                String curr = q.poll();
                if(endWord.equals(curr))
                    return level;
                char[] currArr = curr.toCharArray(); //we will transform each letter in word from a-z, and check if the new word is found in the given word list
                for(int i=0;i<currArr.length;i++){
                    for(char c='a';c<='z';c++){
                        char originalChar = currArr[i]; 
                        currArr[i] = c;
                        String newWord = new String(currArr);
                        if(!curr.equals(newWord) && wordSet.contains(newWord)){
                            q.offer(newWord);
                            wordSet.remove(newWord); //remove from wordList, to prevent re-processing
                        }
                        currArr[i] = originalChar; //restore the original word
                    }
                }
            }
        }
        return 0;
        
    }
}
