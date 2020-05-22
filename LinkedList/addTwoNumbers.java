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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        int carry = 0, sum = 0;
        while(l1!=null && l2!=null){
            sum = carry + l1.val + l2.val;
            carry = sum/10;
            sum = sum%10;
            
            curr.next = new ListNode(sum);
            
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            sum = carry + l1.val;
            carry = sum/10;
            sum = sum%10;
            
            curr.next = new ListNode(sum);
            
            curr = curr.next;
            l1 = l1.next;
        }
        while(l2!=null){
            sum = carry + l2.val;
            carry = sum/10;
            sum = sum%10;
            
            curr.next = new ListNode(sum);
            
            curr = curr.next;
            l2 = l2.next;
        }
        if(carry!=0)
            curr.next = new ListNode(carry);
        
        return head.next;
    }
}
