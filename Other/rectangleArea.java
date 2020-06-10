class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //A,B is bottom left of rectangle 1
        //C,D is top right of rectangle 1
        //E,F is bottom left of rectangle 2
        //G,H is top right of rectangle 2
        
        //first find individual areas of rectangles
        int a1 = (C-A)*(D-B);
        int a2 = (G-E)*(H-F);
        
        //check for overlap rectangle
        
        //compare tops and bottoms of 2 rectangles to check if they overlap
        if(E>=C || D<=F || A>=G || B>=H) //they don't overlap
            return a1+a2;
        
        //below we calculate coordinates of such rectangle
        int left = Math.max(A,E); //comparing bottom lefts
        int right = Math.min(C,G); //comparing top rights
        int top = Math.min(D,H);
        int bottom = Math.max(B,F);
        
        int overlap = 0;
        overlap = (right-left) * (top-bottom);
        
        return a1+a2-overlap;
        
    }
}
