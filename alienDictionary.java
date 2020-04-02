class Solution {
    //two steps
    //1. build graph
    //2. topological sort
    public String alienOrder(String[] words) {
        if(words.length==0)
            return "";
        
        int[] inDegree = new int[26]; //array to store inDegree for every vertex representing a alphabet
        Map<Character,Set<Character>> graph = new HashMap<>(); //adjacency list representing graph
        buildGraph(inDegree, graph, words);
        return topSort(inDegree, graph);
    }
    
    private void buildGraph(int[] inDegree, Map<Character,Set<Character>> graph, String[] words){
        //create map of unique characters of alien words
        for(String word:words){
            char[] ch = word.toCharArray();
            for(char c:ch)
                graph.putIfAbsent(c,new HashSet<Character>());
        }
        for(int x=1;x<words.length;x++){
            String first = words[x-1];
            String second  = words[x];
            
            int len = Math.min(first.length(),second.length());
            //start comparing character by character
            for(int i=0;i<len;i++){
                char src = first.charAt(i);
                char dest = second.charAt(i);
                if(src!=dest){
                    //if chars are not equal, then char in first appears before char in second, so update in graph
                    if(!graph.get(src).contains(dest)){
                        graph.get(src).add(dest);
                        inDegree[dest - 'a'] +=1;
                    }
                    break;
                }
                //for input ["abc","ab"]
                if(i+1==len && first.length()>second.length()){
                    graph.clear();
                    return;
                }
            }
        } 
    }
    private String topSort(int[] inDegree, Map<Character,Set<Character>> graph){
        LinkedList<Character> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        //check inDegree of char (vertices) of created graph
        for(char c:graph.keySet()){
            if(inDegree[c - 'a']==0)
                q.offer(c);
        }
        while(!q.isEmpty()){
            char node = q.poll();
            result.append(node);
            for(char neighbor:graph.get(node)){
                inDegree[neighbor - 'a'] --;
                
                if(inDegree[neighbor - 'a']==0)
                    q.offer(neighbor);
            }
        }
        
        if(result.length()==graph.size())
            return result.toString();
        else
            return "";
    }
}
