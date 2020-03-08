class Solution {
    //this class is created to sort input list in ascending order
    private class IntervalComparator implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            if(a[0]<b[0]) return -1;
            else if (a[0]>b[0]) return 1;
            else return 0;
        }
    }
    public int[][] merge(int[][] intervals) {
        List<int[]> intervalsList = new LinkedList<>();
        //linked list is used as it supports faster insertion and deletion than array list
        LinkedList<int[]> mergedList = new LinkedList<>();
        intervalsList = Arrays.asList(intervals);
        Collections.sort(intervalsList,new IntervalComparator());
        
        for(int[] interval:intervalsList){
            if(mergedList.isEmpty() || mergedList.getLast()[1]<interval[0])
                mergedList.add(interval);
            else
                mergedList.getLast()[1] = Math.max(mergedList.getLast()[1],interval[1]);
        }
        
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}
