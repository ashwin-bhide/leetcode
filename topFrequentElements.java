class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> fCounter= new HashMap<>();  //frequency Counter
        LinkedList<Integer> result =  new LinkedList(); //linkedList so that element can be added at the head
        if(nums==null || nums.length==0)
            return result;
        
        for(int i=0;i<nums.length;++i){
            if(fCounter.containsKey(nums[i]))
                fCounter.put(nums[i],fCounter.get(nums[i])+1);
            else
                fCounter.put(nums[i],1);
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a,b)->fCounter.get(a)-fCounter.get(b)); //lambda expression, while inserting element to heap, ensure that frequency of key a is less than frequency of key b
        
        for(int n:fCounter.keySet()){
            minHeap.add(n);
            if(minHeap.size()>k)   //since, it's minHeap, removes least frequent elements
                minHeap.poll();
        }
        while(!minHeap.isEmpty())
            result.addFirst(minHeap.poll());  //addFirst ensures, that last polled(most frequent) element is at start
        
        return result;
        
        
    }
}
