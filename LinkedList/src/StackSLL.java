
public class StackSLL<T>{
	Node<T> top;
	// append
	public boolean isEmpty() {
		return top == null;
	}
	// Push
	public void push(T data) {
		Node<T> newtop = new Node<T>(data);
		newtop.next = top;
		top = newtop;
	}
	// Pop
	public T pop() {
		if(isEmpty()) {
			System.out.println("Emtpy Stack");
			return null;
		}
		T data = top.data;
		top = top.next;
		return data;
	}
	// Peek
	public T peek() {
		if(isEmpty()) {
			System.out.println("Emtpy Stack");
			return null;
		}
		return top.data;
	}
	// print stack
	public void printStack() {
		if(isEmpty()) {
			System.out.println("Empty Stack");
			return;
		}
		Node<T> current = top;
		while(true) {
			System.out.println("|" + current.data + "|");
			if(current.next == null) {
				System.out.println(" _");
				break;
			}
			current = current.next;
			
		}
	}
}