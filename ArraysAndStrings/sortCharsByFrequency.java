class Solution {
    public class CountComparator implements Comparator<Map.Entry<Character,Integer>>{
        public int compare(Map.Entry<Character,Integer> e1,Map.Entry<Character,Integer> e2){
            int v1 = e1.getValue();
            int v2 = e2.getValue();
            return v2-v1;
        }
    }
    public String frequencySort(String s) {
        if(s.length()==0)
            return s;
        
        StringBuilder result = new StringBuilder();
        Map<Character,Integer> count = new HashMap();
        
        for(char c:s.toCharArray())
            count.put(c,count.getOrDefault(c,0)+1);
        
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue(new CountComparator());
        
        for(Map.Entry<Character,Integer> me:count.entrySet())
            maxHeap.add(me);
        
        while(!maxHeap.isEmpty()){
            Map.Entry<Character,Integer> e = maxHeap.poll();
            for(int i=0;i<e.getValue();i++)
                result.append(e.getKey());
        }
        
        return result.toString();
    }
}
//Time complexity : O(nlogn) where n is length of string
