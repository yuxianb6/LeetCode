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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode cur=head;
        if(cur==null||cur.next==null){
            return head;
        }
        ListNode next=cur.next;
        int size=1;
        while(next!=null){
            cur.next=next.next;
            next.next=prev.next;
            prev.next=next;
            next=cur.next;
            size++;
        }
        k%=size;
        if(k==0){
            return head;
        }
        int round=k-1;
        prev=dummy;
        cur=dummy.next;
        next=cur.next;
        while(round>0){
            cur.next=next.next;
            next.next=prev.next;
            prev.next=next;
            next=cur.next;
            round--;
        }
        prev=cur;
        cur=next;
        next=cur.next;
        int rest=size-k-1;
        while(rest>0){
            cur.next=next.next;
            next.next=prev.next;
            prev.next=next;
            next=cur.next;
            rest--;
        }
        return dummy.next;
    }
}
