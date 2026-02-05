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
        ListNode cur=head;
        int size=0;
        while(cur!=null){
            size++;
            cur=cur.next;
        }
        ListNode[]nodes=new ListNode[size];
        ListNode ptr=head;
        for(int i=0;i<size;i++){
            nodes[i]=ptr;
            ptr=ptr.next;
        }
        swap(nodes,left-1,right-1);
        for(int i=0;i<size-1;i++){
            nodes[i].next=nodes[i+1];
        }
        nodes[size-1].next=null;
        return nodes[0];
    }
    public void swap(ListNode[] nodes,int left,int right){
        while(left<right){
            ListNode tmp=nodes[left];
            nodes[left]=nodes[right];
            nodes[right]=tmp;
            left++;
            right--;
        }
        return;
    }
}