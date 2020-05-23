class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if(A.length==0 || B.length==0)
            return new int[0][0];
        
        int i = 0, j = 0;
        
        List<int[]> result = new ArrayList();
        
        while(i<A.length && j<B.length){
            //find intersectioi point
            int start = Math.max(A[i][0],B[j][0]);
            int end = Math.min(A[i][1],B[j][1]);
            
            if(start<=end)
                result.add(new int[]{start,end});
            
            //increment pointer of interval which ends earlier
            if(A[i][1]<B[j][1])
                i++;
            else
                j++;
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
