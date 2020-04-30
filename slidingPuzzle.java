class Solution {
    //this is a Branch and Bound problem and we'll be using BFS
    //each node represents state of the board at that point
    
    class Node{
        int[][] b ;
        int zr; //row-index at which zero is placed 
        int zc;
        String boardString; //will store serialized board
        int depth; //depth of node in the bfs
        Node(int[][] bv,int r,int c,int d){
            this.b = bv;
            this.zr = r;
            this.zc = c;
            this.depth = d;
            this.boardString = Arrays.deepToString(bv); //alternate of toString() for multi-dimensional arrays
        }
    }
    public int slidingPuzzle(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        
        Queue<Node> q = new ArrayDeque();
        Set<String> seen = new HashSet();
        
        String target = Arrays.deepToString(new int[][]{{1,2,3},{4,5,0}});
        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        //create root node
        //find initial state(location of zero on board)
        int zri=0,zci=0; //index where initially placed zero is found
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                if(board[i][j] == 0){
                    zri = i; zci = j;
                    break;
                }
        
        Node root = new Node(board,zri,zci,0);
        q.offer(root);
        seen.add(root.boardString);
        
        while(!q.isEmpty()){
            Node n = q.poll();
            if(target.equals(n.boardString))
                return n.depth;
            
            for(int[] d:dir){
                int oldR = n.zr;
                int oldC = n.zc;
                
                int newZR = n.zr + d[0]; //new position of zero; row position
                int newZC = n.zc + d[1]; //col position
                
                //check if new indices do not cross boundary of the board
                if(newZR<0 || newZC<0 || newZR>=row || newZC>=col)
                    continue; //skip new node creation for this board state
                
                int[][] newBoard = new int[row][col]; //create new board
                int ri = 0;
                for(int[] rowArray:n.b){
                    newBoard[ri++] = rowArray.clone();
                }
                //swap the cell containing zero with the current direction
                newBoard[n.zr][n.zc] = newBoard[newZR][newZC];
                newBoard[newZR][newZC] = 0;
                
                Node newNode = new Node(newBoard,newZR,newZC,n.depth+1);
                if(seen.contains(newNode.boardString)) //if newly created board already seen before, skip adding to the queue
                    continue;
                q.offer(newNode);
                seen.add(newNode.boardString);
            }
        }
        return -1;
    }
}
