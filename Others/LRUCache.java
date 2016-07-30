
import java.util.HashMap;

class DoublyNode {
	int key;
	int value;
	DoublyNode left;
	DoublyNode right;
	public DoublyNode(int key, int value) {
		this.key = key;
		this.value = value;
		left = null;
		right = null;
	}
}

public class LRUCache {
	int capacity;
	HashMap<Integer, DoublyNode> hm = new HashMap<>();
	DoublyNode head = null;
	DoublyNode tail = null;
	int count = 0;
	public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!hm.containsKey(key))
        	return -1;
        DoublyNode freshNode = hm.get(key);
        
        //move freshNode to the beginning of list
        removeNode(freshNode);
        addFirst(freshNode);
        return freshNode.value;
        
    }
    
    public void set(int key, int value) {
        if(hm.containsKey(key)) {
        	DoublyNode result = hm.get(key);
        	//remove stale node from list
        	removeNode(result);
        	
        	result.value = value;
        	//update list
        	addFirst(result);
        	return;
        }
        
        DoublyNode result = new DoublyNode(key, value);
        //put new node in hashmap and list
        hm.put(key, result);
        addFirst(result);
        
        //check if size of list is greater than capacity
        if(count > capacity) {
        	//remove last element
        	hm.remove(tail.key);
        	removeNode(tail);
        }
        
    }
    
    void removeNode(DoublyNode node) {
    	if(count == 1) {
    		count--;
    		head = null;
    		tail = null;
    		return;
    	}
    	if(head == node) {
    		head = node.right;
    		count--;
    		return;
    	}
    	if(tail == node) {
    		tail = tail.left;
    		count--;
    		return;
    	}
    	DoublyNode leftNode = node.left;
    	DoublyNode rightNode = node.right;
    	leftNode.right = rightNode;
    	rightNode.left = leftNode;
    	count--;
    }
    
    void addFirst(DoublyNode node) {
    	if(head == null) {
    		head = node;
    		tail = node;
    		count++;
    		return;
    	}
    	
    	node.right = head;
    	head.left = node;
    	head = node;
    	count++;
    }

	public static void main(String[] args) {
		LRUCache l = new LRUCache(5);
		l.set(1, 2);
		l.set(2, 3);
		l.set(3, 4);
		l.set(4, 5);
		l.set(5, 6);
		l.set(6, 7);
		
		System.out.println(l.get(5));
		System.out.println(l.get(1));

	}

}
