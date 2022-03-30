/*
* Challenge:
* Create methods to do the following list actions
* - Print all values in the list backward
* - Print all values in the list forward
* - Insert a specific element after every element in the list
* - Check if the values in another linked list are equal to this linked list
*
* Context:
* A linked list is one of the most basic constructs in computer
* science. Unlike an array which may only contain a specified
* number of elements, a linked list may have as many elements as
* the ram available. Each element in a linked list contains a value
* and a pointer to the next element. The head element is the first
* element in the list. A double linked list is like a linked list
* but each object also has a pointer to the previous element. The
* last element in the list is called the tail. Having a pointer
* both forwards and backwards allows you to traverse the list in
* two directions. This is useful for operations such as binary
* search.
*
* What is the <E> and the <T>?:
* 	Having an <E> or <T> in angle brackets allows you to initialize
* 	an object to hold a class type. When the class is initialized,
* 	the <E> or <T> is converted into whichever class the programmer
* 	chooses. In the first line of the DoubleLinkedList<E> class,
* 	the E variable is utilized. If the class were to be initialized
* 	to contain Integers like this:
* 		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
* 	The first line of the class would be converted from:
* 		private Node<E> head, tail;
* 	To:
* 		private Node<Integer> head, tail;
*
* Helpful links:
*	https://en.wikipedia.org/wiki/Linked_list
*	https://en.wikipedia.org/wiki/Binary_search_algorithm
*/

public class DoubleLinkedList<E> {

	private Node<E> head, tail;

	public DoubleLinkedList() {
		clear();
	}

	// Methods you need to create

	public void printBackward() {
		// Fill in this method
		for (int i = size() - 1; i >= 0; i--) {
			System.out.println(get(i).getValue());
		}
	}

	public void printForward() {
		// Fill in this method
		for (int i = 0; i < size(); i++) {
			System.out.println(get(i).getValue());
		}
	}

	public void insertEverywhere(E element) {
		// Fill in this method
		for (int i = 1; i < size(); i += 2) {
			insert(element, i);
		}
		append(element);
	}

	public boolean equals(DoubleLinkedList<E> other) {
		// Fill in this method
		if (this == other)
			return true;
		int sz = size();
		if (sz != other.size())
			return false;
		for (int i = 0; i < sz; i++)
			if (!get(i).getValue().equals(other.get(i).getValue()))
				return false;
		return true;
	}

	// Below this point are methods given to you. You do not need to modify them,
	// but they may give you some hints as to how to create the four methods.
	public void clear() {
		head = null;
		tail = null;
	}

	public void prepend(E element) {
		prepend(new Node<E>(element));
	}

	private void prepend(Node<E> n) {
		if (head == null) {
			initialize(n);
		} else {
			n.setNext(head);
			head.setPrevious(n);
			head = n;
		}
	}

	public void append(E element) {
		append(new Node<E>(element));
	}

	private void append(Node<E> n) {
		if (tail == null) {
			initialize(n);
		} else {
			tail.setNext(n);
			n.setPrevious(tail);
			tail = n;
		}
	}

	public void insert(E element, int index) {
		insert(new Node<E>(element), index);
	}

	private void insert(Node<E> n, int index) {
		if (index == 0) {
			prepend(n);
		} else if (index == size()) {
			append(n);
		} else {
			Node<E> previous = get(index - 1);
			Node<E> next = get(index);
			n.setPrevious(previous);
			n.setNext(next);
			previous.setNext(n);
			next.setPrevious(n);
		}
	}

	public Node<E> get(int index) {
		if (!exists(index)) {
			throw new IllegalArgumentException("The index you supplied is not reachable.");
		}
		Node<E> n = head;
		for (int i = 0; i < index; i++) {
			n = n.getNext();
		}
		return n;
	}

	public void set(E element, int index) {
		get(index).setValue(element);
	}

	public void remove(int index) {
		Node<E> n = get(index);
		Node<E> previous = (n.isPrevious()) ? n.getPrevious() : null;
		Node<E> next = (n.isNext()) ? n.getNext() : null;
		if (previous == null && next == null) {
			head = null;
			tail = null;
		} else if (previous == null) {
			next.setPrevious(null);
			head = next;

		} else if (next == null) {
			previous.setNext(null);
			tail = previous;
		} else {
			next.setPrevious(previous);
			previous.setNext(next);
		}
	}

	private void initialize(Node<E> n) {
		head = n;
		tail = n;
	}

	public int size() {
		if (head == null)
			return 0;
		int elements = 1;
		Node<E> next = head;
		while (next.isNext()) {
			next = next.getNext();
			elements++;
		}
		return elements;
	}

	/** Checks if an index in the list is valid */
	public boolean exists(int index) {
		return size() - 1 >= index && index >= 0;
	}

	public String toString() {
		Node<E> next = head;
		if (next == null) {
			return "null";
		}
		StringBuilder sb = new StringBuilder(next.toString());
		while (next.isNext()) {
			sb.append(" <-> ");
			next = next.getNext();
			sb.append(next.toString());
			// sb.append(next.toString());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		DoubleLinkedList<Integer> dll1 = new DoubleLinkedList<Integer>();
		DoubleLinkedList<Integer> dll2 = new DoubleLinkedList<Integer>();
		DoubleLinkedList<Integer> dll3 = new DoubleLinkedList<Integer>();
		System.out.print("Initializing the lists:\n\n");
		dll1.append(1);
		dll2.append(1);
		dll3.append(1);
		dll1.append(2);
		dll2.append(2);
		dll3.append(2);
		dll1.append(3);
		dll2.append(3);
		dll3.append(3);
		System.out.println("List 1:\t" + dll1);
		System.out.println("List 2:\t" + dll2);
		System.out.println("List 3:\t" + dll3);
		System.out.print("\nPrinting the list backward:\n\n");
		dll1.printBackward();
		System.out.print("\nPrinting the list forward:\n\n");
		dll2.printForward();
		System.out.print("\nInserting an element into list 3:\n\n");
		dll3.insertEverywhere(9);
		System.out.println("List 3:\t" + dll3);
		System.out.print("\nIf the equals method was made incorrectly, an assertion error will be thrown.\n\n");
		fail(dll3.size() == 6, "The insertEverywhere method is incorrect");
		fail(dll1.equals(dll2), "List one should equal list two");
		fail(!dll1.equals(dll3), "List one should not equal list three");
		fail(!dll3.equals(dll2), "List three should not equal list two");
		System.out.print("Lists one and two are the same value, but list three is not.\n\n");
		System.out.println("List 1:\t" + dll1);
		System.out.println("List 2:\t" + dll2);
		System.out.println("List 3:\t" + dll3);
	}

	private static void fail(boolean assertion, String message) {
		if (!assertion)
			throw new AssertionError(message);
	}

}

class Node<T> {
	private T value;
	private Node<T> previous;
	private Node<T> next;

	public Node(T value) {
		this.value = value;
		previous = null;
		next = null;
	}

	public T getValue() {
		return value;
	}

	public boolean isPrevious() {
		return previous != null;
	}

	public boolean isNext() {
		return next != null;
	}

	public Node<T> getPrevious() {
		return previous;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public void setPrevious(Node<T> previous) {
		this.previous = previous;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public String toString() {
		return value.toString();
	}
}
