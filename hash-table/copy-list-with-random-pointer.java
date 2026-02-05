/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node>copy=new HashMap<>();
        Node cur=head;
        while(cur!=null){
            if(!copy.containsKey(cur)){
                copy.put(cur,new Node(cur.val));
            }
            cur=cur.next;
        }
        Node ptr=head;
        while(ptr!=null){
            copy.get(ptr).next=copy.get(ptr.next);
            copy.get(ptr).random=copy.get(ptr.random);
            ptr=ptr.next;
        }
        return copy.get(head);

    }
}