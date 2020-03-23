/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public class ListNodeValueComparator implements Comparator<ListNode>{
        public int compare(ListNode a, ListNode b){
            if(a.val<b.val) return -1;
            else if(a.val>b.val) return 1;
            else return 0;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if(lists==null || k==0)
            return null;
        
        //we'll use minHeap to store k nodes at a time
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new ListNodeValueComparator());
        
        //get heads of all k lists and add to heap
        for(int i=0;i<k;i++){
            if(lists[i]!=null) //handle case when empty linkedlist is present
                minHeap.add(lists[i]);   
        }
        
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while(!minHeap.isEmpty()){
            ListNode minimum = minHeap.poll();
            curr.next = minimum;
            curr = curr.next;
            if(minimum.next!=null)
                minHeap.add(minimum.next); //make sure to not add null node ie, when linkedlist becomes empty
        }
        
        return result.next;
        
    }
}
