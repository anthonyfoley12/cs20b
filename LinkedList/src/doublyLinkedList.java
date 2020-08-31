public class doublyLinkedList<T>{
	doubleNode<T> head;
	// append
	public boolean isEmpty() {
		return head == null;
	}
	public void append(T data) {
		if(isEmpty()) {
			head = new doubleNode<T>(data);
			return;
		}
		doubleNode<T> current = head;
		while(current.next != null) {
			current = (doubleNode<T>) current.next;
		}
		current.next = new doubleNode<T>(data);
		current.next.prev = current;
		return;
	}
	// prepend
	public void prepend(T data) {
		doubleNode<T> newHead = new doubleNode<T>(data);
		head.prev = newHead;
		newHead.next = head;
		head = newHead;
	}
	// remove
	public void remove(T data) {
		if(isEmpty()) return;
		if(head.data == data) {
			head = head.next;
			head.prev = null;
			return;
		}
		doubleNode<T> current = head;
		while(current.next != null) {
			if(current.next.data == data) {
				current.next = current.next.next;
				if(current.next != null) {
					current.next.prev = current;
				}
				return;
			}
			current = current.next;
		}
	}
	// find first
	public void findFirst(T data) {
		if(isEmpty()) {
			System.out.println("Empty List");
		}
		int index = 0;
		doubleNode<T> current = head;
		while(true) {
			if(current.data == data) {
				System.out.println("Value at index: " + index);
				break;
			}
			if(current.next == null) {
				System.out.println(data + " is not in list");
				break;
			}
			current = current.next;
			index++;
		}
	}
	// print list
	public void printList() {
		if(isEmpty()) {
			System.out.println("Empty List");
			return;
		}
		if(head.next == null) {
			System.out.println(head.data);
			return;
		} else {
			doubleNode<T> current = head;
			System.out.println(current.data + "->" + current.next.data);
			current = current.next;
			while(true) {
				if(current.next == null) {
					System.out.println(current.prev.data + "<-" + current.data );
					return;
				} else { 
					System.out.println(current.prev.data + "<-" + current.data + "->" + current.next.data);
				}
				current = current.next;
			}
		}
	}
}