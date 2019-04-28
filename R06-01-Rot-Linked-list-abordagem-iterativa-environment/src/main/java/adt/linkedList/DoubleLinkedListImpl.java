package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	private DoubleLinkedListNode<T> nill = new 	DoubleLinkedListNode<T>() ;
;

	
	public DoubleLinkedListImpl() {
		setHead(nill);
		setLast(nill);
	}	

	@Override
	public void insertFirst(T element) {
		if (element == null) return;
		
		DoubleLinkedListNode<T> head = (DoubleLinkedListNode<T>) getHead();
		
		DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>(element, (DoubleLinkedListNode<T>) head, nill);
		
		head.previous = newHead; 
		setHead(newHead);
		
		if(this.getLast().isNIL()) {
			this.setLast(newHead);
		}
		if(this.getLast().getPrevious()==null) {
			this.getLast().setPrevious(newHead);
		}
	}

	@Override
	public void removeFirst() {
		if(!head.isNIL()) {
			head = head.next;
			if (head.isNIL()) {
				last = (DoubleLinkedListNode<T>) head;
			}
		}
		((DoubleLinkedListNode<T>) head).previous = new DoubleLinkedListNode<T>();
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
