class Solution {
    public class IntervalComparator implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            if(a[0]<b[0]) return -1;
            else if(a[0]>b[0]) return 1;
            else return 0;
        }
    }
    public int minMeetingRooms(int[][] intervals) {
        if(intervals==null) return 0;
        if(intervals.length<2) return intervals.length;
        
        LinkedList<int[]> res = new LinkedList<int[]>();
        //sort by ascending order of start time
        Collections.sort(Arrays.asList(intervals), new IntervalComparator());
        //create list of int[] arrays
        for(int[] interval:intervals)
            res.add(interval);
        //minHeap is used to keep track of meeting which ends the earliest
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        //add end time of first meeting of the day
        minHeap.add(res.get(0)[1]);

        for(int i=1;i<res.size();i++){
            //if there's no overlap between start of next meeting and current minimum end time, replace top of heap(least endtime) with new least endtime 
            if(res.get(i)[0]>=minHeap.peek())
                minHeap.poll();
            
            minHeap.add(res.get(i)[1]);
        }
        return minHeap.size();
    }
}
