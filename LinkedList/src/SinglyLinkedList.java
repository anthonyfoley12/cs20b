public class SinglyLinkedList<T>{
	Node<T> head;
	// append
	public boolean isEmpty() {
		return head == null;
	}
	public void append(T data) {
		if(isEmpty()) {
			head = new Node<T>(data);
			return;
		}
		Node<T> current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = new Node<T>(data);
		return;
	}
	// prepend
	public void prepend(T data) {
		Node<T> newHead = new Node<T>(data);
		newHead.next = head;
		head = newHead;
	}
	// remove
	public void remove(T data) {
		if(isEmpty()) return;
		if(head.data == data) {
			head = head.next;
			return;
		}
		Node<T> current = head;
		while(current.next != null) {
			if(current.next.data == data) {
				current.next = current.next.next;
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
		Node<T> current = head;
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
		Node<T> current = head;
		while(true) {
			System.out.print(current.data);
			if(current.next == null) {
				break;
			}
			System.out.print("->");
			current = current.next;
			
		}
	}
}