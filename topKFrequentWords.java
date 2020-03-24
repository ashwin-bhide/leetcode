class Solution {
    public class HeapValueComparator implements Comparator<Map.Entry<String,Integer>>{
        public int compare(Map.Entry<String,Integer> e1,Map.Entry<String,Integer> e2){
            Integer v1 = e1.getValue();
            Integer v2 = e2.getValue();
            if(v1<v2) return -1;
            else if(v1>v2) return 1;
            else return e2.getKey().compareTo(e1.getKey()); //compares lexicographically
        }        
    }
    public List<String> topKFrequent(String[] words, int k) {
        LinkedList<String> result = new LinkedList<String>();
        if(words==null || words.length==0)
            return result;
        HashMap<String,Integer> hm = new HashMap<>();
        for(String word:words){
            hm.put(word,hm.getOrDefault(word,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> minHeap = new PriorityQueue<>(new HeapValueComparator());
        for(Map.Entry<String,Integer> entry:hm.entrySet()){
            minHeap.add(entry);
            if(minHeap.size()>k)
                minHeap.poll();
        }
        
        for(int i=0;i<k;i++)
            result.addFirst(minHeap.poll().getKey());
        
        return result;
        
    }
}
