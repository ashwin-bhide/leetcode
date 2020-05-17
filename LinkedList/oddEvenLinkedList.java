/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //there are 2 cases
    //1->2->3->4->5->null //input contains odd number of nodes
    //1->2->3->4->5->6->null //input contains even number of nodes
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) //if input contains 0 or 1 nodes
            return head;
        
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        
        ListNode oddCurr = oddHead;
        ListNode evenCurr = evenHead;
        
        while(evenCurr!=null && evenCurr.next!=null){
            oddCurr.next = evenCurr.next;
            oddCurr = oddCurr.next;
            evenCurr.next = oddCurr.next;
            evenCurr = evenCurr.next;
        }
        oddCurr.next = evenHead;
        
        return oddHead;
    }
}
