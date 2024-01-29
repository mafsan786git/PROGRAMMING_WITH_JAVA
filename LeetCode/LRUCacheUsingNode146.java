import java.util.HashMap;
import java.util.Map;

public class LRUCacheUsingNode146 {
    private Map<Integer,Node> cache;
    private int capacity;
    private Node left;
    private Node right;


    LRUCacheUsingNode146(int capacity){
        this.capacity = capacity;
        cache = new HashMap<>();
        //left = LRU , right = most recent
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public int get(int key){
        if(cache.containsKey(key)){
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).val;
        }
        return -1;
    }

    public void put(int key,int value){
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        cache.put(key, new Node(key, value));
        insert(cache.get(key));

        if(cache.size() > capacity){
            Node leastNode = this.left.next;
            remove(leastNode);
            cache.remove(leastNode.key);
        }
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void insert(Node node){
        Node prev = this.right.prev;
        Node next = this.right;

        prev.next = node;
        next.prev = node;

        node.next = next;
        node.prev = prev;
    }

    private class Node{
        private int key;
        private int val;
        Node next;
        Node prev;

        Node(int key,int val){
            this.key =key;
            this.val =val;
        }
    }


}
