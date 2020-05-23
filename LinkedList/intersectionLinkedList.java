/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode currA, currB;
        currA = headA;
        currB = headB;
        
        while(currA!=null){
            lenA++;
            currA = currA.next;
        }
        while(currB!=null){
            lenB++;
            currB = currB.next;
        }
        
        int diff = lenA-lenB;
        
        if(diff<0) {//a is smaller
            for(int i=0;i<Math.abs(diff);i++)
                headB = headB.next;
        } else if(diff>0){ //b is smaller
            for(int i=0;i<Math.abs(diff);i++)
                headA = headA.next;
        }
        
        while(headA!=null || headB!=null){
            if(headA==headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
            
    }
}
