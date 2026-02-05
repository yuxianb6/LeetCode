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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev=head;
        for(int i=0;i<left-2;i++){
            prev=prev.next;
        }
        ListNode cur=prev.next;
        if(cur==null){
            return head;
        }
        ListNode next=cur.next;
        for(int j=0;j<right-left;j++){
            cur.next=next.next;
            next.next=prev.next;
            prev.next=next;
            next=cur.next;
        }
        return head;


    }
   
}