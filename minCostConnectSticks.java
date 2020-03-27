class Solution {
    public int connectSticks(int[] sticks) {
        if(sticks==null || sticks.length<2)
            return 0;
        
        int result = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int s:sticks){
            result+=s;
            minHeap.offer(s);
            
        }
        
        while(minHeap.size()>=3){
            int combinedStick = minHeap.poll() + minHeap.poll();
            result+=combinedStick;
            minHeap.offer(combinedStick);
        }
        
        return result;
    }
}
