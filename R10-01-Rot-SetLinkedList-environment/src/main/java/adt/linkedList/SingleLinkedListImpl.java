package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> aux = head;
		while(!aux.isNIL()) {
			size++;
			aux = aux.next;
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> aux = head;
		while(!aux.isNIL() && aux.getData() !=(element)) {
			aux = aux.getNext();
		}
		return aux.data;
	}

	@Override
	public void insert(T element) {
		if (element == null) return;
		SingleLinkedListNode<T> node = new SingleLinkedListNode<T>(element, new SingleLinkedListNode<T>());

		if (head.isNIL()) {
			head = node;
			return;
		}
		
		SingleLinkedListNode<T> aux = head;

		while(!aux.next.isNIL()) {
			aux = aux.next;
		}
		aux.next = node;
		}

	@Override
	public void remove(T element) {
		if(element == null) return;
		if(this.isEmpty()) return;
		
		SingleLinkedListNode<T> aux = head;
		SingleLinkedListNode<T> oldNode = aux;
		while(!aux.isNIL() && !aux.getData().equals(element)) {
			oldNode = aux;
			aux = aux.getNext();
		}
		oldNode.next = aux.next;
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		int i = 0;
		SingleLinkedListNode<T> aux = head;
		while(!aux.isNIL()) {
			array[i] = aux.getData();
			aux = aux.getNext();
			i++;
		}
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
