class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(-101);
        dummy.next=head;
        ListNode cur=head;
        ListNode prev=dummy;
        while(cur!=null){
            if(cur.next!=null&&cur.val==cur.next.val){
                int val=cur.val;
                while(cur.val==val){
                    cur=cur.next;
                }
                prev.next=cur;
            }else{
                prev=prev.next;
                cur=cur.next;
            }
        }
        return dummy.next;
    
    }
}
