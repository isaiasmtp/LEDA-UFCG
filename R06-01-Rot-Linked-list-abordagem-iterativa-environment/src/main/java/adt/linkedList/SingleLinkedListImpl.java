package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return	this.head.isNIL();
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
		
		while(!aux.isNIL() && !aux.getData().equals(element)){
			aux = aux.next;
		}
		return aux.getData();
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> node = new SingleLinkedListNode<T>(element,new SingleLinkedListNode<>());;
		
		if(head.isNIL()) {
			head = node;
		}else {
			SingleLinkedListNode<T> aux = head;
			
			while(!aux.next.isNIL()) {
				aux = aux.next;
			}
			node.next = aux.next;
			aux.next = node;			
		}
	}

	@Override
	public void remove(T element) {
		if(head.getData() == element){
			head = head.next;
			
		}else {
			SingleLinkedListNode<T> oldNode = new SingleLinkedListNode<T>();
			SingleLinkedListNode<T> aux = head;
			
			while(!(aux.getData().equals(element))) {
				oldNode = aux;
				aux = aux.next;
			}
			
			if(!(aux.isNIL())) {
				oldNode.next =aux.next;
			}
		}		
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[this.size()];
		int cont = 0;
		
		SingleLinkedListNode<T> aux = head;
		while(!aux.isNIL()) {
			array[cont] = aux.getData();
			aux = aux.next;
			cont++;
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
