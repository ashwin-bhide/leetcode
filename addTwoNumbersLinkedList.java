/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); //creation of dummy head is important, helps in returning result head
        ListNode curr=dummyHead;
        int sum=0, carry=0;
        while(l1!=null || l2!=null){
            int x = (l1==null)?0:l1.val; //very useful step ,if node is null, consider value as zero
            int y = (l2==null)?0:l2.val;
            sum = x+y+carry;
            carry=sum/10;   //order is imprtant, calculate carry before doing mod
            sum = sum%10;
            curr.next = new ListNode(sum);
            curr=curr.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        if(carry>0)
            curr.next=new ListNode(carry);
        return dummyHead.next;
    }
}
