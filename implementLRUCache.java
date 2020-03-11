class LRUCache {
    //2 data structures used; 1 doubly linked list for fast insertion/deletion
    //hashmap for fast searching 
    //in this problem, we are interested in 2 key functions, adding to the front of list and removing from end of list, so we use dummy head and tail for quick access to these nodes
    ListNode head,tail;  
    Map<Integer,ListNode> hm = new HashMap<>();
    
    int maxCapacity;
    int currCapacity;
    
    private class ListNode{
        int key;
        int value;
        ListNode prev;
        ListNode next;
    }
    
    private void moveToHead(ListNode node){
        removeFromList(node);
        addToFront(node);
    }
    
    private void removeFromList(ListNode node){
        //regular node removal from doubly linked list
        ListNode prevNode = node.prev;
        ListNode nextNode = node.next;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        
        currCapacity--;
    }
    
    private void addToFront(ListNode node){
        //add given node to front of the list
        node.next = head.next;
        node.prev = head;
        
        head.next.prev = node;
        head.next = node;
        currCapacity++;
    }
    
    private void removeLRUEntry(){
        ListNode lastEntry = tail.prev;
        removeFromList(lastEntry);
    }
    
    private int peekTail(){
        ListNode node = tail.prev;
        return node.key;
    }

    public LRUCache(int capacity) {
        this.head = new ListNode(); //we are using dummy head and tail nodes; very important to avoid null issues
        this.tail = new ListNode();
        this.maxCapacity = capacity;
        this.currCapacity = 0;
        
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        ListNode node = hm.get(key);
        if(node==null)
            return -1;
        moveToHead(node);
        return node.value;
        
    }
    
    public void put(int key, int value) {
        ListNode node = hm.get(key);
        if(node == null){
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;
            addToFront(newNode);
            if(currCapacity>maxCapacity){
                hm.remove(peekTail());
                removeLRUEntry();
            }
            hm.put(key,newNode);
            
        } else{
            node.value = value;
            hm.put(key,node);
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
