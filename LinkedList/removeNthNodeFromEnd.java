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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return null;
        
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode slow,fast;
        slow = dummyHead;
        fast = dummyHead;
        while(n>0){
            fast = fast.next;
            n--;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = (slow.next==null)?null:slow.next.next; //handle case when n=0
        return dummyHead.next;
    }
}
