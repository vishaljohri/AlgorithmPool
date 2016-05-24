import java.util.HashSet;


public class Node {
	int data;
	Node next = null;
	
	Node(int data) {
		this.data = data;
	}
	
	void appendToTail(int d) {
		Node n = new Node(d);
		Node cur = this;
		while(cur.next != null) {
			cur = cur.next;
		}
		cur.next = n;
	}
	
	void display() {
		Node cur = this;
		while(cur.next != null) {
			System.out.print(cur.data + "->");
			cur = cur.next;
		}
		System.out.println(cur.data);
	}
	
	Node delete(int data) {
		Node head = this;
		Node cur = head.next;
		Node prev = head;
		
		if(head.data == data) {
			head.next = null;
			return cur;
		}
		else {
			while(cur != null) {
				if(cur.data == data) {
					prev.next = cur.next;
					break;
				}
				else {
					prev = cur;
					cur = cur.next;
				}
			}
		}
		
		return head;
	}
	
	void removeDuplicates() {
		HashSet<Integer> hs = new HashSet<>();
		Node cur = this;
		Node prev = null;
		while(cur != null) {
			if(hs.add(cur.data) == false) {
				System.out.println("duplicate element found: " + cur.data);
				prev.next = cur.next;
				cur = cur.next;
				continue;
			}
			prev = cur;
			cur = cur.next;
		}
	}
	
	boolean deleteMiddle() {
		boolean flag = false;
		Node cur = this;
		Node middle = this;
		Node middlePrevious = null;
		while(cur != null && cur.next != null) {
			cur = cur.next.next;
			middlePrevious = middle;
			middle = middle.next;
		}
		System.out.println("middle element is: " + middle.data);
		if(middlePrevious != null) {
			middlePrevious.next = middle.next;
		}
		
		return flag;
	}
	
	Node partition(int x) {
		Node cur = this;
		Node first = null;
		Node headFirst = null;
		Node second = null;
		Node headSecond = null;
		
		while(cur != null) {
			if(cur.data < x) {
				if(headFirst == null) {
					first = cur;
					headFirst = first;
				}
				else {
					first.next = cur;
					first = first.next;
				}
			}
			else {
				if(headSecond == null) {
					second = cur;
					headSecond = second;
				}
				else {
					second.next = cur;
					second = second.next;
				}
			}
			cur = cur.next;
		}
		
		if(first != null) {
			first.next = headSecond;
		}
		
		if(second != null) {
			second.next = null;
		}
		
		return headFirst;
		
	}
	
	Node pairWiseReverse() {
		Node cur = this;
		Node nextCur = cur.next;
		Node head = nextCur;
		Node nextNextCur = nextCur.next;
		
		while(nextNextCur != null) {
			cur.next = nextNextCur.next;
			nextCur.next = cur;
			cur = nextNextCur;
			nextCur = nextNextCur.next;
			nextNextCur = nextCur.next;	
		}
		nextCur.next = cur;
		cur.next = null;
		
		return head;
	}
	
	Node reverse() {
		Node cur = this;
		Node prev = null;
		Node nextCur = cur.next;
		
		while(nextCur != null) {
			cur.next = prev;
			prev = cur;
			cur = nextCur;
			nextCur = nextCur.next;
		}		
		cur.next = prev;
		return cur;
	}
	
	void kLast(int k) {
		Node cur = this;
		Node prev = this;
		for(int i = 1; i < k; i++) {
			if(cur.next == null) {
				System.out.println("kth last element doesn't exist");
				return;
			}
			cur = cur.next;
		}
		
		while(cur.next != null) {
			cur = cur.next;
			prev = prev.next;
		}
		
		System.out.println("kth last element is: " + prev.data);		
	}
	
	void pallindrome() {
		Node cur = this;
		Node reverse = cur.reverse();
		while(cur != null) {
			if(cur.data != reverse.data) {
				System.out.println("not pallindrome");
				return;
			}
			cur = cur.next;
		}
		System.out.println("pallindrome");
	}
	
	void pallindromeOptimized() {
		Node cur = this;
		Node slow = this;
		Node slowPrevious = this;
		Node fast = this;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slowPrevious = slow;
			slow = slow.next;
		}
		slowPrevious.next = null;
		Node reverse = null;
		//even length
		if(fast == null) {
			reverse = slow.reverse();
		}
		//odd length
		else {
			reverse = slow.next.reverse(); 
		}
		
		while(cur != null) {
			if(cur.data != reverse.data) {
				System.out.println("not pallindrome");
				return;
			}
			cur = cur.next;
			reverse = reverse.next;
		}
		System.out.println("pallindrome list");
	}
	
	private void IsCircular() {
		Node fast = this;
		Node slow = this;
		
		while(fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				System.out.println("link list is circular");
				return;
			}
			
		}
		System.out.println("link list is non-circular");
		
	}
	
	void beginLoop() {
		Node fast = this;
		Node slow = this;
		boolean flag = false;
		while(fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				System.out.println("link list is circular");
				flag = true;
				break;
			}
			
		}
		if(flag) {
			slow = this;
			while(slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			System.out.println("start node of the loop is: " + slow.data);
		}
		else {
			System.out.println("link list is non-circular");
		}
	}
	
	public void reorderList() {
		Node head = this;
        if(head == null || head.next == null || head.next.next == null)
            return;
        
        //find middle element of list
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //reverse list after slow/middle element
        Node prevCur = null;
        Node cur = slow.next;
        Node nextCur = cur.next;
        while(nextCur != null) {
            cur.next = prevCur;
            prevCur = cur;
            cur = nextCur;
            nextCur = nextCur.next;
        }
        cur.next = prevCur;
        slow.next = cur;
        
        //reorder list
        Node startFirst = head;
        Node startSecond = slow.next;
        slow.next = null;
        Node startSecondNext = startSecond.next;
        while(startSecondNext != null) {
            startSecond.next = startFirst.next;
            startFirst.next = startSecond;
            startFirst = startSecond.next;
            startSecond = startSecondNext;
            startSecondNext = startSecondNext.next;
        }
        startSecond.next = startFirst.next;
        startFirst.next = startSecond;
    }

	public static void main(String[] args) {
		Node newNode = new Node(5);
		newNode.appendToTail(7);
		newNode.appendToTail(2);
		newNode.appendToTail(4);
		newNode.appendToTail(9);
		newNode.appendToTail(7);
		newNode.appendToTail(4);
		newNode.appendToTail(4);
		newNode.appendToTail(1);
		newNode.appendToTail(8);
		System.out.println("original list");
		newNode.display();
		System.out.println("list after deleting element");
		newNode = newNode.delete(4);
		newNode.display();
		System.out.println("list after removing duplicates");
		newNode.removeDuplicates();
		newNode.display();
		System.out.println("list after removing middle element");
		newNode.deleteMiddle();
		newNode.display();
		System.out.println("after partitioning");
		Node nd = newNode.partition(4);
		nd.display();
		System.out.println("after reversing the list");
		Node rv = nd.reverse();
		rv.display();
		
		Node pall = new Node(4);
		pall.appendToTail(5);
		pall.appendToTail(6);
		pall.appendToTail(5);
		pall.appendToTail(4);
		pall.appendToTail(1);
		System.out.println("checking pallindrome");
		pall.display();
		//pall.pallindrome();
		pall.pallindromeOptimized();
		
		System.out.println("after pair wis reverse");
		rv.display();
		rv = rv.pairWiseReverse();
		rv.display();
		
		System.out.println("kth last element is");
		rv.kLast(1);
		
		System.out.println("checking for circular list");
		Node cur = rv;
		while(cur.next != null) {
			cur = cur.next;
		}
		cur.next = rv;
		rv.IsCircular();
		
		System.out.println("checking for begin loop");
		rv.beginLoop();

	}

}
