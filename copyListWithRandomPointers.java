/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        //create curr pointer to traverse through the list
        Node curr = head;
        while(curr!=null){
            Node nn = new Node(curr.val); //cloned value node created
            nn.next = curr.next; //new node points to original node's next
            curr.next = nn; //original node points to new node
            curr = curr.next.next; //move to next original node in list
        }
        curr = head;
        //connect random pointers as per original list
        while(curr!=null){
            curr.next.random = (curr.random==null)?null:curr.random.next; 
            curr=curr.next.next;
        }
        curr = head;
        Node newHead = head.next;
        Node newCurr = newHead;
        //reconnect next nodes of original and new lists
        while(curr!=null){
            curr.next = (curr.next==null)?null:curr.next.next;
            newCurr.next = (newCurr.next==null)?null:newCurr.next.next;
            
            curr=curr.next;
            newCurr=newCurr.next;
        }
        return newHead;
    }
}
