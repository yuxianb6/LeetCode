class Node {
    int key;
    int val;
    Node next;
    Node prev;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
class LRUCache {

    int capacity;
    Map<Integer,Node> dic;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity; 
        dic = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!dic.containsKey(key)){
            return -1;
        }
        Node node=dic.get(key);
        remove(node);
        add(node);
        return node.val;

        
    }
    public void put(int key, int value) {
        if(dic.containsKey(key)){
            Node oldNode = dic.get(key);
            remove(oldNode);
        }
        Node node = new Node(key, value);
        dic.put(key, node);
        add(node);
        if(dic.size()>capacity){
            Node nodeToDelete = head.next;
            remove(nodeToDelete);
            dic.remove(nodeToDelete.key);
        }
        
    }
    private void add(Node node) {
        Node previousEnd = tail.prev;
        previousEnd.next = node;
        node.prev = previousEnd;
        node.next = tail;
        tail.prev = node;        

    }
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */