package listClass;

import java.util.Iterator;

public class BasicLinkedList<T> implements Iterable<T> {
	/* This class is a basic linked list. Each data element is contained in a Node. There is a head reference and a
	 * tail reference. 
	 * 
	 */

	private static class Node<X> {

		//Private Instance Variables
		private X data;
		private Node<X> next;

		//Private Constructor that wraps the data in a node and sets the next reference to null
		private Node(X data) {
			this.data = data;
			this.next = null;
		}
	}

	//Private Instance Variables
	private Node<T> head;
	private Node<T> tail;
	private int size;

	//Constructor that creates an empty list
	public BasicLinkedList(){
		this.head = null;
		this.size = 0;
	}

	//Getter for the size of the list
	public int getSize() {
		return this.size;
	}

	//This method adds an element to the tail of the list and returns a reference to the current list
	public BasicLinkedList<T> addToEnd(T data) {
		Node<T> node = new Node<>(data);
		if(tail == null) {
			tail = node;
			if(head == null) {
				head = node;
			} else {
				head.next = tail;
			}
		} else {
			tail.next = node;
			node.next = null;
			tail = node;
		}

		size++;
		return this;
	}

	//This method adds an element to the head of the list and returns a reference to the current list
	public BasicLinkedList<T> addToFront(T data) {
		Node<T> node = new Node<>(data);
		node.next = head;
		head = node;
		size++;
		return this;
	}

	//Returns the head element without removing it from the list.
	public T getFirst() {
		return head.data;
	}

	//Returns the tail element without removing it from the list.
	public T getLast() {
		return tail.data;
	}

	//Removes and returns the head element. If list is empty returns null.
	public T retrieveFirstElement() {
		Node<T> temp = head;
		head = head.next;
		temp.next = null;
		size--;
		return temp.data;
	}

	//Removes and returns the tail element. If list is empty returns null.
	public T retrieveLastElement() {
		Node<T> temp = tail;
		for(Node<T> curr = head; curr != null; curr = curr.next) {
			if(curr.next == tail) {
				curr.next = null;
				tail = curr;
			}
		}
		size--;
		return temp.data;
	}

	//Removes all instances of target element in the list. Returns a reference to the list.
	public BasicLinkedList<T> removeAllInstances(T targetData) {
		Node<T> prev = null;
		for(Node<T> curr = head; curr != null;) {
			if(curr.data.equals(targetData)) {
				if(curr == head) { //If its the head
					curr = head.next;
					head.next = null;
					head = curr;
					size--;
				} else if(curr == tail) { //If its the tail
					prev.next = null;
					tail = prev;
					size--;
				} else { 				//If its somewhere in the middle
					prev.next = curr.next;
					prev = curr;
					curr = curr.next;
					prev.next = null;
					size--;
				}
			}
			prev = curr;
			curr = curr.next;
		}
		return this;
	}

	//Returns an Iterator
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			private Node<T> pos = head;

			@Override
			public boolean hasNext() {
				return (pos == null)? false : true;
			}

			@Override
			public T next() {
				T element = pos.data;
				pos = pos.next;
				return element;
			}

		};
	}
}