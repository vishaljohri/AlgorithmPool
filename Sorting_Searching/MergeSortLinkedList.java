package leetcode.ques;


class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
		next = null;
	}
}

public class MergeSortLinkedList {
	ListNode head = null;
	void insert(int value) {
		if(head == null) {
			head = new ListNode(value);
		}
		else {
			ListNode cur = head;
			while(cur.next != null) {
				cur = cur.next;
			}
			cur.next = new ListNode(value);
		}
	}
	
	public ListNode sortList(ListNode cur) {
		if(cur == null || cur.next == null)
			return cur;
		int length = 0;
		ListNode firstHead = cur;
		while(cur != null) {
			length++;
			cur = cur.next;
		}
		cur = firstHead;
		//divide list into two parts
		int half = length / 2;
		int count = 0;
		ListNode prev = null;
		while(count != half) {
			count++;
			prev = cur;
			cur = cur.next;
		}
		prev.next = null;
		ListNode secondHead = cur;
		ListNode h1 = sortList(firstHead);
		ListNode h2 = sortList(secondHead);
		
		//merge the two lists
		ListNode merged = mergeLists(h1, h2);
		
		return merged;
	}
	
	ListNode mergeLists(ListNode h1, ListNode h2) {
		ListNode mergedHead = null;
		if(h1.val < h2.val) {
			mergedHead = h1;
			h1 = h1.next;
		}
		else {
			mergedHead = h2;
			h2 = h2.next;
			mergedHead.next = h1;
			
		}
			
		ListNode previous = mergedHead;
		while(h1 != null && h2 != null) {
			if(h1.val < h2.val) {
				previous = h1;
				h1 = h1.next;
			}
			else {
				ListNode curSecond = h2;
				h2 = h2.next;
				previous.next = curSecond;
				previous = curSecond;
				previous.next = h1;
				
			}
		}
		
		while(h2 != null) {
			previous.next = h2;
			previous = previous.next;
			h2 = h2.next;
		}
		return mergedHead;
	}
	
	void display(ListNode cur) {
		while(cur != null) {
			System.out.println(cur.val);
			cur = cur.next;
		}
	}

	public static void main(String[] args) {
		MergeSortLinkedList m = new MergeSortLinkedList();
		m.insert(4);
		m.insert(2);
		m.insert(5);
		m.insert(1);
		m.insert(7);
		
		m.head = m.sortList(m.head);
		m.display(m.head);
	}

}
