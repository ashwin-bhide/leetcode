/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null)
            return false;
        
        ListNode slow, fast;
        slow = head;
        fast = head;
        while(fast!=null){
            slow = slow.next;
            fast = (fast.next==null)?null:fast.next.next;
            if(slow==fast)
                return true;
        }
        return false;
    }
}
