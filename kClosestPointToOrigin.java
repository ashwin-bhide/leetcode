class Solution {
    public class DistanceCompare implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            if(calDistance(a[0],a[1])>calDistance(b[0],b[1])) return -1;
            else if(calDistance(a[0],a[1])<calDistance(b[0],b[1])) return 1;
            else return 0;
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new DistanceCompare());
        
        for(int[] point:points){
            maxHeap.offer(point);
            if(maxHeap.size()>K)
                maxHeap.poll();
        }
        
        int[][] result = new int[maxHeap.size()][];
        int i=0;
        while(!maxHeap.isEmpty()){
            result[i++] = maxHeap.poll();
        }
        
        return result;
    }
    public int calDistance(int a, int b){
        return a*a+b*b;
    }
}
